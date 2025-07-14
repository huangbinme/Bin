package com.interview.tradedesk;

import java.util.List;
import java.util.Optional;

public interface CloudStorage {

    boolean addFile(String name, int size);

    Optional<Integer> getFileSize(String name);

    Optional<Integer> deleteFile(String name);

    List<String> getNLargest(String prefix, int n);

    /**
     * Should add a new user in the system, with `capacity` as
     * their storage limit in bytes.
     * The total size of all files owned by `userId` cannot exceed
     * `capacity`.
     * The operation fails if a user with `userId` already exists.
     * Returns `true` if a user with `userId` is successfully
     * created, or `false` otherwise.
     */
    boolean addUser(String userId, int capacity);

    /**
     * Should behave in the same way as the `addFile` from Level 1,
     * but the added file should be owned by the user with
     * `userId`.
     * A new file cannot be added to the storage if doing so will
     * exceed the user's `capacity` limit.
     * Returns the remaining capacity of the user if the file is
     * added successfully, or `Optional.empty()` otherwise.
     * <p>
     * *Note that* all queries calling the `addFile` operation
     * implemented during Level 1 are run by the user with
     * `userId = "admin"`, who has unlimited storage capacity.
     */
    Optional<Integer> addFileBy(String userId, String name, int size);

    /**
     * Should merge the account of `userId2` with the `userId1`.
     * Ownership of all of `userId2`'s files is transferred to
     * `userId1`, and any remaining storage capacity is also added
     * to `userId1`'s limit.
     * `userId2` is deleted if the merge is successful.
     * Returns the remaining capacity of `userId1` after merging,
     * or `Optional.empty()` if one of the users does not exist or
     * `userId1` is equal to `userId2`.
     * It is guaranteed that neither `userId1` nor `userId2` equals
     * `"admin"`.
     */
    Optional<Integer> mergeUser(String userId1, String userId2);

    /**
     * Should back up the current state of all files owned by
     * `userId` - i.e., file names and sizes.
     * The backup is stored on a separate storage system and is not
     * affected by any new file manipulation queries.
     * Overwrites any backups for the same user if previous backups
     * exist.
     * Returns the number of backed-up files, or `Optional.empty()`
     * if `userId` does not exist.
     */
    Optional<Integer> backupUser(String userId);

    /**
     * Should restore the state of `userId`'s files to the latest
     * backup.
     * If there was no backup, all of `userId`'s files are deleted.
     * If a file can't be restored because another user added
     * another file with the same name, it is ignored.
     * Returns the number of the files that are successfully
     * restored or `Optional.empty()` if `userId` does not exist.
     * <p>
     * *Note that* `mergeUser` does not affect `userId1`'s backup,
     * and `userId2` is deleted along with its backup.
     * *Note that* the `restoreUser` operation does not affect the
     * user's capacity.
     */
    Optional<Integer> restoreUser(String userId);
}
