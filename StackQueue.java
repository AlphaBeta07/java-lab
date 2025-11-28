// StackInterface.java
public interface StackInterface {
    void push(int x);
    int pop();
    int peek();
    void display();
}

// QueueInterface.java
public interface QueueInterface {
    void enqueue(int x);
    int dequeue();
    void display();
}

// StackQueue.java
public class StackQueue implements StackInterface, QueueInterface {
    private int[] arr = new int[100];
    private int top = -1;
    private int front = 0, rear = 0; // queue uses [front, rear)

    // Stack
    public void push(int x) { if (top+1 < arr.length) arr[++top]=x; else System.out.println("Stack overflow"); }
    public int pop() { if (top>=0) return arr[top--]; else { System.out.println("Stack underflow"); return -1; }
    }
    public int peek() { return top>=0 ? arr[top] : -1; }
    public void display() {
        System.out.print("Stack: ");
        for(int i=0;i<=top;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Queue (simple circular)
    public void enqueue(int x) {
        if (rear == arr.length) System.out.println("Queue full");
        else arr[rear++]=x;
    }
    public int dequeue() {
        if (front==rear) { System.out.println("Queue empty"); return -1; }
        return arr[front++];
    }
    public void displayQueue() {
        System.out.print("Queue: ");
        for(int i=front;i<rear;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
    // To satisfy both display signatures, call display() for stack and displayQueue() for queue
    public void display() { display(); }
    // small test
    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(10); sq.push(20); sq.display();
        System.out.println("Popped: " + sq.pop());
        sq.enqueue(1); sq.enqueue(2);
        System.out.println("Dequeued: " + sq.dequeue());
        sq.displayQueue();
    }
}
