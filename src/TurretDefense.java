/**
 * Created by edwardwang on 12/26/15.
 */

/**
 * You have been given a list of incoming targets that must be shot down in the order they are given. Assuming you
 * turret is aimed at some location, it will take time to move the turret and fire at a different location. If you are
 * currently aimed at point (a,b), and you must move to aim at point (c,d), the time required is the absolute difference
 * in first coordinates plus the absolute difference in second coordinates. For example, starting at (3,7) it will take
 * 4 seconds to aim at point (5,5). Along with the coordinates of each incoming target, you are also given their arrival
 * times. The turret must be fired precisely at the arrival time in the direction of the target. Immediately after
 * firing, the turret can be moved to aim at the next location (no time is lost firing). Your method will return the
 * index of the earliest target that cannot be shot down. For example, let's assume
 xs    = {3,5,6}
 ys    = {7,5,6}
 times = {11,15,16}.
 Your turret always begins aimed at (0,0) at time 0. Since the first target is arriving at location (3,7) at time 11 you
 have 11 seconds to move there and fire. This is 1 second more than is needed. At time 11 you fire the turret, and
 immediately start moving to aim at (5,5). Since the second target arrives at time 15, you have 4 seconds to aim. This
 is exactly enough time. At time 15, you fire at the second target. Unfortunately, the third target will arrive before
 you can shoot it down. You would return 2 since target 2 (third target) is the earliest one you couldn't shoot down.
 If you could shoot them all down, return -1. As shown above, xs[i],ys[i] are the coordinates, and times[i] is the
 arrival time of target i.

 ------------- ------------- ------------- ------------- ------------- ------------- ------------- ------------- ------
 Definition
 Class: TurretDefense
 Method: firstMiss
 Parameters: int[], int[], int[]
 Returns: int
 Method signature: int firstMiss(int[] xs, int[] ys, int[] times)
 (be sure your method is public)
 Limits
 Time limit (s): 840.000
 Memory limit (MB): 64
 Notes
 - xs will contain between 2 and 50 elements inclusive.
 - ys and times will contain the same number of elements as xs.
 - Each element of xs will be between 0 and 1000 inclusive.
 - Each element of ys will be between 0 and 1000 inclusive.
 - Each element of times will be between 1 and 1000000 inclusive.
 - The elements of times will be in strictly increasing order.

 ------------- ------------- ------------- ------------- ------------- ------------- ------------- ------------- ------
 EXAMPLES
 0)
 {3,5,6}
 {7,5,6}
 {11,15,16}
 Returns: 2
 From above.
 1)
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32}
 Returns: -1
 A target arrives every 2 seconds. Luckily it only takes 2 seconds to switch from target to target.
 2)
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,31}
 Returns: 15
 Same as before, but now you only have 1 second to switch to the final target.
 3)
 {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0};
 {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0};
 {2000,4000,6000,8000,10000,12000,14000,16000,18000,20000, 22000,24000,26000,28000,30000,32000,34000,36000,38000,40000, 42000,44000,46000,48000,50000,52000,54000,56000,58000,60000, 62000,64000,66000,68000,70000,72000,74000,76000,78000,80000, 82000,84000,86000,88000,90000,92000,94000,96000,98000,100000};
 Returns: -1
 Takes a while, but you hit them all.
 4)
 {4,5}
 {4,5}
 {7,8}
 Returns: 0
 5)
 {1,2,3,4,15}
 {1,2,3,4,15}
 {100,200,300,400,405}
 Returns: 4
 */
class Main{
 public static void main(String[]args){
  int[] ia_XCoordinate = {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0};
  int[] ia_YCoordinate = {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0};
  int[] ia_Time = {2000,4000,6000,8000,10000,12000,14000,16000,18000,20000, 22000,24000,26000,28000,30000,32000,34000,36000,38000,40000, 42000,44000,46000,48000,50000,52000,54000,56000,58000,60000, 62000,64000,66000,68000,70000,72000,74000,76000,78000,80000, 82000,84000,86000,88000,90000,92000,94000,96000,98000,100000};
  /**
   * To call non static methods, create instances of the object.
   */
  TurretDefense td_TurretDefense = new TurretDefense();
  System.out.println("Result: "+ td_TurretDefense.firstMiss(ia_XCoordinate, ia_YCoordinate,ia_Time));
 }
}

public class TurretDefense {
 private int i_XCoordinate;
 private int i_YCoordinate;
 private int i_StageTime=1;
 private int i_AbsoluteDifference;

 /**
  * 1]Check the absolute difference between old position and new position
  * 2]Compare the difference to the time
  * --if(difference>time){ return most recent time where object is shot down}
  * --else{return -1 because all objects are shot down}
  * @param x
  * @param y
  * @param time
  * @return i_DefenseResult
  */
 public int firstMiss(int[] x, int[] y, int[] time){
  if(isArrayRulesFollowed(x,y,time)){
   for(int i=0;i<time.length;i++){
    if(isXAndYCoordinateRulesFollowed(x[i],y[i]) && isTimeRulesFollowed(i_StageTime,time[i])){
     setI_StageTime(time[i]);
     i_AbsoluteDifference += getAbsoluteDifference(x[i],y[i]);
     if(i_AbsoluteDifference > i_StageTime){
      return i;
     }
     setNewCoordinates(x[i], y[i]);
     printCoordinatesAndDifference(i,i_AbsoluteDifference);
    }
   }
  }
  return -1;
 }
 private boolean isArrayRulesFollowed(int[] x, int[] y, int[] time){
  if(x.length>=2 && x.length<=50){
   if(y.length==x.length && time.length==x.length){
    return true;
   }
  }
  return false;
 }
 private boolean isXAndYCoordinateRulesFollowed(int x, int y){
  if(x>=0 && x<=1000 && y>=0 && y<=1000) return true;
  return false;
 }
 private boolean isTimeRulesFollowed(int timeBefore, int timeCurrent){
  if(timeCurrent>=1 && timeCurrent<=1000000){
   if(timeBefore < timeCurrent){
    return true;
   }
  }
  return false;
 }

 private void setI_StageTime(int i_StageTime){
  this.i_StageTime = i_StageTime;
 }
 private void setNewCoordinates(int i_XCoordinate, int i_YCoordinate){
  this.i_XCoordinate = i_XCoordinate;
  this.i_YCoordinate = i_YCoordinate;
 }

 private int getAbsoluteDifference(int x, int y){
  return (Math.abs(x-i_XCoordinate)) + (Math.abs(y-i_YCoordinate));
 }

 private void printCoordinatesAndDifference(int stage, int i_AbsoluteDifference){
  System.out.println(stage+"]X="+i_XCoordinate);
  System.out.println(stage+"]Y="+i_YCoordinate);
  System.out.println(stage+"]Stage="+i_StageTime);
  System.out.println("Difference: "+i_AbsoluteDifference);
 }

}














