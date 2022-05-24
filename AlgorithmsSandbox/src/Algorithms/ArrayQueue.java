package Algorithms;

class ArrayQueue {
    int[] array;
    int queueLength = 0;
    int headIndex = 0;
    int nextFree = 0;
    int capacity = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public boolean add(int value) {
        if(queueLength == array.length) {
            return false;
        } else {
            array[nextFree] = value;
            nextFree = nextFree + 1;
            if (nextFree == array.length) {
                nextFree = 0;
            }
            queueLength = queueLength + 1;
        }
        return true;
    }

    public int get() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException();
        }
        int value = array[headIndex];
        headIndex = headIndex + 1;
        queueLength = queueLength - 1;
        if (headIndex == array.length) {
            headIndex = 0;
        }
        return value;
    }

    public boolean isEmptyIfElse() {
        if (queueLength == 0) {
            return true;
        }
        return false;
    }
    public boolean isEmptyTernar() {
        return queueLength == 0 ? true : false;
    }

    public boolean isEmpty() {
        return queueLength == 0;
    }

    public int peek() throws QueueIsEmptyException { //что находится в голове очереди
        if(isEmpty()) {
            throw new QueueIsEmptyException();
        }
        return array[headIndex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array: ");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if(i != array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("; ");
        stringBuilder.append("headIndex: ").append(headIndex);
        stringBuilder.append("; ");
        stringBuilder.append("nextFree: ").append(nextFree);
        stringBuilder.append("; ");
        stringBuilder.append("queueLength: ").append(queueLength);
        return stringBuilder.toString();
    }
}
