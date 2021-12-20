import java.util.Arrays;

public class MyHeap {
    private int[] elem;
    private int usedSize;
    public MyHeap(){
        elem=new int[10];
    }
    public MyHeap(int k){
        elem=new int[k];
    }
    public void creatHeap(int[] nums){
        //数组赋值
        for(int i=0;i<nums.length;i++){
            elem[i]=nums[i];
            this.usedSize++;
        }
        //进行调整
        for(int i=nums.length/2-1;i>=0;i--){
            adjustDown(i,usedSize);
        }
    }
    private void adjustDown(int k,int usedSize){
        int parent=k;
        int child=2*k+1;
        while(child<usedSize){
            if(child+1<usedSize&&elem[child]<elem[child+1]){
                child++;
            }
            if(elem[child]>elem[parent]){
                swap(elem,child,parent);
                parent=child;
                child=2*parent+1;
            }else {
                break;
            }

        }
    }
    private void adjustUp(int child){
        while(child>0){
            int parent=(child-1)/2;
            if(elem[parent]<elem[child]){
                swap(elem,child,parent);
                child=parent;
            }else {
                break;
            }
        }
    }
    public void offer(int val) {
        if(isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = val;//10
        this.usedSize++;//11
        adjustUp(this.usedSize-1);//10下标
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    public void poll() {
        if(isEmpty()) {
            return;
        }
        swap(elem,0,this.usedSize-1);
        this.usedSize--;//9 删除了
        adjustDown(0,this.usedSize);
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.elem[0];
    }




    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int[] arr={1,4,2,5,6,3,7,9,0};
        MyHeap myHeap=new MyHeap(20);
        myHeap.creatHeap(arr);
        System.out.println();
    }

}
