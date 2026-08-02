class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort((a, b) -> a.position - b.position);

        double x = calc(target,
                cars.get(speed.length - 1).position,
                cars.get(speed.length - 1).speed);

        int count = 1;

        for (int i = speed.length - 2; i >= 0; i--) {

            double time = calc(target,
                    cars.get(i).position,
                    cars.get(i).speed);

            if (time > x) {
                count++;
                x = time;
            }
        }

        return count;
    }

    class Car {
        int position;
        int speed;

        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public double calc(int target, int position, int speed) {
        return (double) (target - position) / speed;
    }
}