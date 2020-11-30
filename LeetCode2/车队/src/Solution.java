//N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
//每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
//一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
//此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
//车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
//即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
//会有多少车队到达目的地?
class Cars{
    public int position;
    public double time;
    public Cars(int position,double time){
        this.position = position;
        this.time = time;
    }
}
public class Solution {
    public static int carFleet(int target, int[] position, int[] speed){
        if(position == null || speed == null)return 0;
        if(position.length == 0 || speed.length == 0)return 0;
        Cars[] cars = new Cars[position.length];
        for (int i = 0;i < position.length;i++){
            cars[i] = new Cars(position[i],(double)(target - position[i]) / speed[i]);
        }
        quickSort(cars);
        int ans = 1;
        for (int i = 0;i < cars.length - 1;i++){
            if (cars[i].time >= cars[i + 1].time){
                cars[i + 1].time = cars[i].time;
            }else {
                ans++;
            }
        }
        return ans;
    }
    //快排
    public static void quickSort(Cars[] cars){
        quick(cars,0,cars.length - 1);
    }
    public static void quick(Cars[] cars,int low,int high){
        if (low > high)return;
        int pivot = partion(cars,low,high);
        quick(cars,low,pivot - 1);
        quick(cars,pivot + 1,high);
    }
    public static int partion(Cars[] cars,int start,int end){
        Cars temp = cars[start];
        while (start < end){
            while (start < end && cars[end].position <= temp.position){
                end--;
            }
            if (start < end){
                cars[start] = cars[end];
            }else {
                break;
            }
            while (start < end && cars[start].position >= temp.position){
                start++;
            }
            if (start < end){
                cars[end] = cars[start];
            }else {
                break;
            }
        }
        cars[start] = temp;
        return start;
    }
}

