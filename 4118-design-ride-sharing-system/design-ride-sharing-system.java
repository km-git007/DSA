class RideSharingSystem {

        private Set<Integer> cancelledRiders, availableRiders;
        private Deque<Integer> riderQueue, driverQueue;

        public RideSharingSystem() {
            cancelledRiders = new HashSet<>();
            availableRiders = new HashSet<>();
            riderQueue = new ArrayDeque<>();
            driverQueue = new ArrayDeque<>();
        }

        public void addRider(int riderId) {
            riderQueue.add(riderId);
            availableRiders.add(riderId);
        }

        public void addDriver(int driverId) {
            driverQueue.add(driverId);
        }

        public int[] matchDriverWithRider() {
            // Skip cancelled riders first
            while(!riderQueue.isEmpty() && cancelledRiders.contains(riderQueue.peekFirst())) {
                riderQueue.pollFirst();
            }

            // Check if we can make a match
            if (driverQueue.isEmpty() || riderQueue.isEmpty()) {
                return new int[]{-1, -1};
            }

            // Both are available, make the match
            int driverId = driverQueue.pollFirst();
            int riderId = riderQueue.pollFirst();

            return new int[]{driverId, riderId};
        }

        public void cancelRider(int riderId) {
            if(availableRiders.contains(riderId)) {
                cancelledRiders.add(riderId);
            }
        }
    }
