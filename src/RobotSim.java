import java.security.PublicKey;
import java.util.*;

public class RobotSim {
    public enum Driction{
        UP,RIGHT,DOWN,LEFT
    }
    public HashMap<Integer, List<Integer>> xMap;
    private HashMap<Integer, List<Integer>> yMap;
    private void getXMap(int[][] obstacles){
        for (int i = 0; i < obstacles.length; i++){
            List<Integer> o = xMap.get(obstacles[i][0]);
            if(o == null){
                o = new ArrayList<Integer>();
                o.add(obstacles[i][1]);
                xMap.put(obstacles[i][0], o);
            }else {
                o.add(obstacles[i][1]);
            }
        }
        for (Integer key: xMap.keySet()){
            Collections.sort(xMap.get(key));
        }
    }
    private void getYMap(int[][] obstacles){
        for (int i = 0; i < obstacles.length; i++){
            List<Integer> o = yMap.get(obstacles[i][1]);
            if(o == null){
                o = new ArrayList<Integer>();
                o.add(obstacles[i][0]);
                yMap.put(obstacles[i][1], o);
            }else {
                o.add(obstacles[i][0]);
            }
        }
        for (Integer key: yMap.keySet()){
            Collections.sort(yMap.get(key));
        }

    }
    private void getNextPossion(int[] lastDriction, int step, Driction drict){
        List<Integer> oList = new ArrayList<Integer>();
        switch (drict){
           case UP:{
               lastDriction[1] = lastDriction[1] + step;
               first:
               for(Integer key: xMap.keySet()){
                   if(lastDriction[0] == key){
                       for(int i = 0; i<=xMap.get(key).size() - 1; i++){
                           if (lastDriction[1] >= xMap.get(key).get(i) && lastDriction[1] - step < xMap.get(key).get(i)){
                               lastDriction[1] =  xMap.get(key).get(i) - 1;
                               break first;
                           }
                       }
                   }
               }
               break;
           }
           case RIGHT: {
               lastDriction[0] = lastDriction[0] + step;
               first:
               for(Integer key: yMap.keySet()){
                   if(lastDriction[1] == key){
                       for(int i= 0; i <=yMap.get(key).size() - 1; i++){
                           if (lastDriction[0] >= yMap.get(key).get(i) && lastDriction[0] - step < yMap.get(key).get(i)){
                               lastDriction[0] =  yMap.get(key).get(i) - 1;
                               break first;
                           }
                       }
                   }
               }
               break;
           }
            case DOWN:{
                lastDriction[1] = lastDriction[1] - step;
                first:
                for(Integer key: xMap.keySet()){
                    if(lastDriction[0] == key){
                        List<Integer> o = xMap.get(key);
                        for(int i = o.size()-1; i >=0; i--){
                            if (lastDriction[1] <= o.get(i) && lastDriction[1] + step > o.get(i)){
                                lastDriction[1] = o.get(i) + 1;
                                break first;
                            }
                        }
                    }
                }
                break;
            }
           case LEFT: {
               lastDriction[0] = lastDriction[0] - step;
               first:
               for(Integer key: yMap.keySet()){
                   if(lastDriction[1] == key){
                       for(int i = yMap.get(key).size() - 1; i >= 0; i--){
                           if (lastDriction[0] <= yMap.get(key).get(i) && lastDriction[0] + step > yMap.get(key).get(i)){
                               lastDriction[0] =  yMap.get(key).get(i) + 1;
                               break first;
                           }
                       }
                   }
               }
               break;
           }
           default: break;
       }
    }
    public int robotSimFinalDistance(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int[] nextPossion = {0, 0};
        xMap = new HashMap<>();
        yMap = new HashMap<>();
         getXMap(obstacles);
         getYMap(obstacles);
         System.out.println(yMap);
        Driction eLastDrict = Driction.UP;
        for (int i = 0; i < commands.length; i++) {
            if(commands[i] == -1){
                eLastDrict = Driction.values()[(eLastDrict.ordinal() + 1) % 4];
            }else if(commands[i] == -2){
                eLastDrict = Driction.values()[(eLastDrict.ordinal() + 3) % 4];
            }else {
                getNextPossion(nextPossion, commands[i], eLastDrict);
                System.out.println(nextPossion[0]+"  "+ nextPossion[1]);
            }
        }
        return nextPossion[0] * nextPossion[0] + nextPossion[1] * nextPossion[1] ;
    }


    public int robotSimOffical(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 15) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 15) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args){
        int a = 1;
        RobotSim o = new RobotSim();
//        int[] commands = {4,-1,4,-2,4};
//        int[][] obstacles = {};
        int[] commands = {2,-1,-1,-2,-1,-2,5,-1,9,-1,7,4,6,9,9,9,-1,2};
        int[][] obstacles = {{-3,2},{-2,1},{0,4},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.println(o.robotSimOffical(commands,obstacles));
    }
}
