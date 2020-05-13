
import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i].uuid = null;
        }
    }

    public void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                sizeStorage++;
                break;
            }
        }
    }

    public String get(String uuid) {
        return uuid;
    }

    public void delete(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i].uuid = null;
            }
        }
        int zeroCount = 0;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid != null) {
                storage[zeroCount++].uuid = storage[i].uuid;
            }
        }
        sizeStorage--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, sizeStorage);
    }

    public int size() {
        return sizeStorage;
    }
}
