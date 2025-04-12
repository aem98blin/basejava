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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }

            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
            }
        }

        for (int i = 0; i < storage.length; i++) {
            if(storage[i]==null && storage[i+1]!=null){
                storage[i]=storage[i+1];
                storage[i+1]=null;
            } else {
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tempArray = new Resume[size()];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
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
