/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null && resume.toString().equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tempArray = new Resume[size];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = storage[i];
        }
        return tempArray;
    }

    int size() {
        return this.size;
    }
}

