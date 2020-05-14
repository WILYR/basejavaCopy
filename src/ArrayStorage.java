
import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        sizeStorage = 0;
    }

    public void save(Resume r) {
        for (int i = 0; i < sizeStorage + 1; i++) {
            if (!(storage[i] instanceof Resume)) {
                storage[i] = r;
                sizeStorage++;
                break;
            }
        }
    }

    public Resume get(String uuid) {
        Resume memory = null;
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                memory = storage[i];
            }

        }
        return memory;
    }

    public void delete(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
            }
        }
        int zeroCount = 0;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i] instanceof Resume) {
                storage[zeroCount++] = storage[i];
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
