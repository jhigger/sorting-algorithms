void main() throws InterruptedException {
    IO.println("Hello, World!");

    long start = System.nanoTime();

    // ======= program start =======

    Thread.sleep(3000);

    // =============================

    long duration =  (System.nanoTime() - start)/1000000;
    System.out.println(duration+"ms");
}