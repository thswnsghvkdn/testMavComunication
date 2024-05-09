//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class MAVLink {
//    public static class MAVLinkParamList extends ArrayList<MAVLinkParam> {
//        private final ReadWriteLock locker = new ReentrantReadWriteLock();
//        private int totalReported;
//
//        public int getTotalReported() {
//            return totalReported;
//        }
//
//        public int getTotalReceived() {
//            return size();
//        }
//
//        public MAVLinkParam getByName(String name) {
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        return item;
//                    }
//                }
//            } finally {
//                locker.readLock().unlock();
//            }
//            return null;
//        }
//
//        public void setByName(String name, MAVLinkParam value) {
//            int index = 0;
//            locker.writeLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        set(index, value);
//                        return;
//                    }
//                    index++;
//                }
//                add(value);
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        public MAVLinkParam getByNames(String[] names) {
//            MAVLinkParam item = null;
//            for (String s : names) {
//                MAVLinkParam newItem = getByName(s);
//                if (newItem != null) {
//                    if (item != null) {
//                        // found multiple items in list
//                        return null;
//                    }
//                    item = newItem;
//                }
//            }
//            return item;
//        }
//
//        public Iterable<String> getKeys() {
//            return () -> new MAVLinkParamIterator(this);
//        }
//
//        public boolean containsKey(String name) {
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        return true;
//                    }
//                }
//                return false;
//            } finally {
//                locker.readLock().unlock();
//            }
//        }
//
//        @Override
//        public void clear() {
//            locker.writeLock().lock();
//            try {
//                totalReported = 0;
//                super.clear();
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        @Override
//        public boolean add(MAVLinkParam item) {
//            setByName(item.getName(), item);
//            return true;
//        }
//
//
//        public boolean addAll(List<? extends MAVLinkParam> collection) {
//            locker.writeLock().lock();
//            try {
//                super.addAll(collection);
//                return true;
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        public Map<String, Double> toDictionary() {
//            Map<String, Double> copy = new HashMap<>();
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    copy.put(item.getName(), item.getValue());
//                }
//                return copy;
//            } finally {
//                locker.readLock().unlock();
//            }
//        }
//
//        public void setTotalReported(int totalReported) {
//            this.totalReported = totalReported;
//        }
//    }
//
//    public static class MAVLinkParam {
//        private final String name;
//        private final double value;
//
//        public MAVLinkParam(String name, double value) {
//            this.name = name;
//            this.value = value;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public double getValue() {
//            return value;
//        }
//    }
//
//    private static class MAVLinkParamIterator implements java.util.Iterator<String> {
//        private final MAVLinkParamList list;
//        private int currentIndex;
//
//        MAVLinkParamIterator(MAVLinkParamList list) {
//            this.list = list;
//            this.currentIndex = 0;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return currentIndex < list.size();
//        }
//
//        @Override
//        public String next() {
//            return list.get(currentIndex++).getName();
//        }
//    }
//}
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class MAVLink {
//    public static class MAVLinkParamList extends ArrayList<MAVLinkParam> {
//        private final ReadWriteLock locker = new ReentrantReadWriteLock();
//        private int totalReported;
//
//        public int getTotalReported() {
//            return totalReported;
//        }
//
//        public int getTotalReceived() {
//            return size();
//        }
//
//        public MAVLinkParam getByName(String name) {
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        return item;
//                    }
//                }
//            } finally {
//                locker.readLock().unlock();
//            }
//            return null;
//        }
//
//        public void setByName(String name, MAVLinkParam value) {
//            int index = 0;
//            locker.writeLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        set(index, value);
//                        return;
//                    }
//                    index++;
//                }
//                add(value);
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        public MAVLinkParam getByNames(String[] names) {
//            MAVLinkParam item = null;
//            for (String s : names) {
//                MAVLinkParam newItem = getByName(s);
//                if (newItem != null) {
//                    if (item != null) {
//                        // found multiple items in list
//                        return null;
//                    }
//                    item = newItem;
//                }
//            }
//            return item;
//        }
//
//        public Iterable<String> getKeys() {
//            return () -> new MAVLinkParamIterator(this);
//        }
//
//        public boolean containsKey(String name) {
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    if (item.getName().equals(name)) {
//                        return true;
//                    }
//                }
//                return false;
//            } finally {
//                locker.readLock().unlock();
//            }
//        }
//
//        @Override
//        public void clear() {
//            locker.writeLock().lock();
//            try {
//                totalReported = 0;
//                super.clear();
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        @Override
//        public boolean add(MAVLinkParam item) {
//            setByName(item.getName(), item);
//            return true;
//        }
//
//
//        public boolean addAll(List<? extends MAVLinkParam> collection) {
//            locker.writeLock().lock();
//            try {
//                super.addAll(collection);
//                return true;
//            } finally {
//                locker.writeLock().unlock();
//            }
//        }
//
//        public Map<String, Double> toDictionary() {
//            Map<String, Double> copy = new HashMap<>();
//            locker.readLock().lock();
//            try {
//                for (MAVLinkParam item : this) {
//                    copy.put(item.getName(), item.getValue());
//                }
//                return copy;
//            } finally {
//                locker.readLock().unlock();
//            }
//        }
//
//        public void setTotalReported(int totalReported) {
//            this.totalReported = totalReported;
//        }
//    }
//
//    public static class MAVLinkParam {
//        private final String name;
//        private final double value;
//
//        public MAVLinkParam(String name, double value) {
//            this.name = name;
//            this.value = value;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public double getValue() {
//            return value;
//        }
//    }
//
//    private static class MAVLinkParamIterator implements java.util.Iterator<String> {
//        private final MAVLinkParamList list;
//        private int currentIndex;
//
//        MAVLinkParamIterator(MAVLinkParamList list) {
//            this.list = list;
//            this.currentIndex = 0;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return currentIndex < list.size();
//        }
//
//        @Override
//        public String next() {
//            return list.get(currentIndex++).getName();
//        }
//    }
//}
