class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a,b) -> b - a);
        
    }
    
   public void addNum(int num) {
    maxheap.offer(num);

    // Move the largest of left side to right side
    minheap.offer(maxheap.poll());

    // Balance sizes (left side should be >= right side)
    if (minheap.size() > maxheap.size()) {
        maxheap.offer(minheap.poll());
    }
}
    
   public double findMedian() {
    if (minheap.isEmpty() && maxheap.isEmpty()) {
        return 0;
    }

    if (minheap.size() == maxheap.size()) {
        return (minheap.peek() + maxheap.peek()) / 2.0;
    } 
    else if (minheap.size() > maxheap.size()) {
        return minheap.peek();
    } 
    else {
        return maxheap.peek();
        }
    }
}
