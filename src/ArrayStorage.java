/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
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
        int sizeArray = size();

        for (int i = 0; i < storage.length; i++) {
            if (sizeArray != 0) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = storage[sizeArray - 1];
                    storage[sizeArray - 1] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int sizeArray = size();
        Resume[] tempArray = new Resume[sizeArray];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = storage[i];
        }
        return tempArray;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            count++;
        }
        return count;
    }
}
