
import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
        sizeStorage = 0;
    }

    public void save(Resume r) {
        storage[sizeStorage] = r;
        sizeStorage++;
    }

    public Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                resume = storage[i];
            }

        }
        return resume;
    }

    public void delete(String uuid) {
        int count = 0;
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                count = i;
            }
        }
        for (int i = 0; i < sizeStorage; i++) {
            if (i == count) {
                storage[i] = storage[i + 1];
                count++;
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
