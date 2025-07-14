package com;

import com.interview.tradedesk.CloudStorageImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CloudStorageImplTest {


    @Test
    void testLevel4Case01PureBackup() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 20));
        Assert.assertEquals(Optional.of(5), storage.addFileBy("user", "/file", 15));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(15), storage.getFileSize("/file"));
    }

    @Test
    void testLevel4Case02Restore() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 20));
        Assert.assertEquals(Optional.of(5), storage.addFileBy("user", "/file", 15));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(15), storage.deleteFile("/file"));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user"));
        Assert.assertEquals(Optional.of(15), storage.getFileSize("/file"));
    }

    @Test
    void testLevel4Case03RestoreDeletesOtherFiles() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 40));
        Assert.assertEquals(Optional.of(0), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(10), storage.addFileBy("user", "/dir/file.txt", 30));
        Assert.assertEquals(Optional.of(0), storage.addFileBy("user", "/dir/file.mp4", 10));
        Assert.assertEquals(Optional.of(0), storage.restoreUser("user"));
        Assert.assertTrue(storage.getFileSize("/dir/file.txt").isEmpty());
    }

    @Test
    void testLevel4Case04MultipleUsers() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user1", 40));
        Assert.assertTrue(storage.addUser("user2", 40));
        Assert.assertEquals(Optional.of(20), storage.addFileBy("user1", "/dir/text.txt", 20));
        Assert.assertEquals(Optional.of(30), storage.addFileBy("user2", "/movie.mp4", 10));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user1"));
        Assert.assertEquals(Optional.of(20), storage.deleteFile("/dir/text.txt"));
        Assert.assertEquals(Optional.of(30), storage.addFileBy("user1", "/file", 10));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user1"));
        List<String> expected = new ArrayList<>(List.of("/dir/text.txt(20)", "/movie.mp4(10)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 4));
        Assert.assertEquals(Optional.of(50), storage.mergeUser("user2", "user1"));
        Assert.assertEquals(Optional.of(2), storage.backupUser("user2"));
        Assert.assertEquals(Optional.of(20), storage.deleteFile("/dir/text.txt"));
        Assert.assertEquals(Optional.of(2), storage.restoreUser("user2"));
        Assert.assertEquals(expected, storage.getNLargest("/", 4));
    }

    @Test
    void testLevel4Case05MultipleBackups() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 100));
        Assert.assertEquals(Optional.of(70), storage.addFileBy("user", "/file1", 30));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(60), storage.addFileBy("user", "/file3", 10));
        Assert.assertEquals(Optional.of(2), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(40), storage.addFileBy("user", "/file4", 20));
        Assert.assertEquals(Optional.of(2), storage.restoreUser("user"));
        List<String> expected = new ArrayList<>(List.of("/file1(30)", "/file3(10)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 3));
    }

    @Test
    void testLevel4Case06UnexistingUsers() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("someUser", 100));
        Assert.assertTrue(storage.restoreUser("user").isEmpty());
        Assert.assertTrue(storage.backupUser("user").isEmpty());
        Assert.assertTrue(storage.addFileBy("user", "/file", 10).isEmpty());
        Assert.assertTrue(storage.getFileSize("/file").isEmpty());
        Assert.assertTrue(storage.backupUser("user").isEmpty());
        Assert.assertTrue(storage.addUser("user", 10));
        Assert.assertEquals(Optional.of(0), storage.restoreUser("user"));
        Assert.assertTrue(storage.getFileSize("/file").isEmpty());
    }

    @Test
    void testLevel4Case07Mixed1() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user1", 40));
        Assert.assertTrue(storage.addUser("user2", 40));
        Assert.assertEquals(Optional.of(20), storage.addFileBy("user1", "/dir/text.txt", 20));
        Assert.assertEquals(Optional.of(30), storage.addFileBy("user2", "/movie.mp4", 10));
        Assert.assertTrue(storage.addFile("/directory/file", 30));
        Assert.assertEquals(Optional.of(1), storage.backupUser("admin"));
        Assert.assertEquals(Optional.of(30), storage.deleteFile("/directory/file"));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user1"));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user2"));
        Assert.assertEquals(Optional.of(50), storage.mergeUser("user2", "user1"));
        Assert.assertTrue(storage.restoreUser("user1").isEmpty());
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user2"));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("admin"));
        Assert.assertTrue(storage.getFileSize("/dir/text.txt").isEmpty());
        Assert.assertEquals(Optional.of(10), storage.getFileSize("/movie.mp4"));
        Assert.assertEquals(Optional.of(30), storage.getFileSize("/directory/file"));
    }

    @Test
    void testLevel4Case08Mixed2() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 10));
        Assert.assertEquals(Optional.of(5), storage.addFileBy("user", "/files/file", 5));
        Assert.assertEquals(Optional.of(1), storage.addFileBy("user", "/file.txt", 4));
        Assert.assertEquals(Optional.of(2), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(4), storage.deleteFile("/file.txt"));
        Assert.assertTrue(storage.addFile("/file.txt", 10));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user"));
        Assert.assertEquals(Optional.of(10), storage.getFileSize("/file.txt"));
        Assert.assertEquals(Optional.of(10), storage.deleteFile("/file.txt"));
        Assert.assertEquals(Optional.of(2), storage.restoreUser("user"));
        Assert.assertEquals(Optional.of(4), storage.getFileSize("/file.txt"));
    }

    @Test
    void testLevel4Case09Mixed3() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user1", 10));
        Assert.assertTrue(storage.addUser("user2", 6));
        Assert.assertEquals(Optional.of(3), storage.addFileBy("user1", "/dir/file1.mp4", 7));
        Assert.assertEquals(Optional.of(0), storage.addFileBy("user1", "/file3.mp4", 3));
        Assert.assertEquals(Optional.of(2), storage.backupUser("user1"));
        Assert.assertEquals(Optional.of(0), storage.backupUser("user2"));
        Assert.assertEquals(Optional.of(7), storage.deleteFile("/dir/file1.mp4"));
        Assert.assertEquals(Optional.of(3), storage.deleteFile("/file3.mp4"));
        Assert.assertEquals(Optional.of(5), storage.addFileBy("user2", "/dir/file1.mp4", 1));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user1"));
        Assert.assertEquals(Optional.of(1), storage.getFileSize("/dir/file1.mp4"));
        Assert.assertEquals(Optional.of(0), storage.restoreUser("user2"));
        Assert.assertEquals(Optional.of(2), storage.addFileBy("user2", "/dir/file2.mov", 4));
        Assert.assertEquals(Optional.of(9), storage.mergeUser("user1", "user2"));
        Assert.assertFalse(storage.addUser("user1", 20));
        Assert.assertTrue(storage.addUser("user2", 4));
        Assert.assertEquals(Optional.of(0), storage.backupUser("admin"));
        Assert.assertTrue(storage.addFileBy("user2", "/dir/file3.png", 5).isEmpty());
        Assert.assertEquals(Optional.of(13), storage.mergeUser("user1", "user2"));
        List<String> expected = new ArrayList<>(List.of("/dir/file2.mov(4)", "/file3.mp4(3)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 2));
        Assert.assertEquals(Optional.of(2), storage.restoreUser("user1"));
        Assert.assertTrue(storage.addFile("/new_file", 1));
        expected = new ArrayList<>(List.of("/dir/file1.mp4(7)", "/file3.mp4(3)", "/new_file(1)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 3));
        Assert.assertEquals(Optional.of(0), storage.restoreUser("admin"));
        expected = new ArrayList<>(List.of("/dir/file1.mp4(7)", "/file3.mp4(3)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 3));
        Assert.assertTrue(storage.restoreUser("user2").isEmpty());
    }

    @Test
    void testLevel4Case10Mixed4() {
        CloudStorageImpl storage = new CloudStorageImpl();
        Assert.assertTrue(storage.addUser("user", 10));
        Assert.assertTrue(storage.addUser("newUser", 10));
        Assert.assertEquals(Optional.of(5), storage.addFileBy("user", "/pic/img.png", 5));
        Assert.assertEquals(Optional.of(6), storage.addFileBy("newUser", "/report.xml", 4));
        Assert.assertEquals(Optional.of(1), storage.backupUser("user"));
        Assert.assertEquals(Optional.of(4), storage.deleteFile("/report.xml"));
        Assert.assertEquals(Optional.of(5), storage.deleteFile("/pic/img.png"));
        Assert.assertEquals(Optional.of(6), storage.addFileBy("user", "/pic/img.png", 4));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user"));
        Assert.assertTrue(storage.getFileSize("/file.txt").isEmpty());
        Assert.assertEquals(Optional.of(5), storage.getFileSize("/pic/img.png"));
        Assert.assertEquals(Optional.of(5), storage.deleteFile("/pic/img.png"));
        Assert.assertEquals(Optional.of(1), storage.addFileBy("user", "/pic/img.png", 9));
        Assert.assertEquals(Optional.of(9), storage.getFileSize("/pic/img.png"));
        Assert.assertEquals(Optional.of(11), storage.mergeUser("user", "newUser"));
        Assert.assertTrue(storage.addUser("newUser", 60));
        Assert.assertEquals(Optional.of(71), storage.mergeUser("user", "newUser"));
        Assert.assertEquals(Optional.of(1), storage.restoreUser("user"));
        Assert.assertEquals(Optional.of(5), storage.getFileSize("/pic/img.png"));
        Assert.assertEquals(Optional.of(73), storage.addFileBy("user", "/img.png", 2));
        Assert.assertEquals(Optional.of(2), storage.backupUser("user"));
        Assert.assertTrue(storage.backupUser("newUser").isEmpty());
        Assert.assertEquals(Optional.of(5), storage.deleteFile("/pic/img.png"));
        Assert.assertTrue(storage.addFileBy("user", "/img.png", 9).isEmpty());
        Assert.assertTrue(storage.addFileBy("user", "/img.png", 8).isEmpty());
        List<String> expected = new ArrayList<>(List.of("/img.png(2)"));
        Assert.assertEquals(expected, storage.getNLargest("/", 2));
    }
}