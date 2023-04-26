public class TestQueue {
    public static void main(String[] args) {
        QueueArrayBased<Integer> queue = new QueueArrayBased<Integer>();

        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        System.out.println("Enqueue: " + queue);
        System.out.println();

        for (int i = 0; i < 10; i++)
            System.out.println(queue.dequeue());
        System.out.println("Dequeue: " + queue);
        System.out.println();

        try {
            queue.dequeue();
        } catch (QueueException e) {
            System.out.println("Exception caught exceptionally well!");
            System.out.println();
        }

        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        System.out.println("Re-enqueue: " + queue);
        System.out.println();

        queue.dequeueAll();
        System.out.println("Dequeue All: " + queue);
        System.out.println();
    }

}
