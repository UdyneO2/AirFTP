package com.udyneos.airftp;

import com.udyneos.airftp.IProgressCallback;

interface IFileService {
    void destroy() = 16777114;

    String[] list(String dir) = 1;
    void start(in String[] srcs, in String[] dsts, boolean move, IProgressCallback cb) = 2;
    void cancel() = 3;
    String[] browse(String dir) = 9;
    boolean mkdir(String path) = 8;

    int listen(String destDir, String pin, String deviceName, IProgressCallback cb) = 4;
    void stopListen() = 5;
    void send(String host, int port, String pin, String deviceName, in String[] srcs, IProgressCallback cb) = 6;
    String checkPair(String host, int port, String pin, String deviceName) = 7;

    String[] remoteList(String host, int port, String pin, String deviceName, String path) = 10;
    void push(String host, int port, String pin, String deviceName, in String[] srcs, String remoteDir, IProgressCallback cb) = 11;
    void pull(String host, int port, String pin, String deviceName, in String[] remotePaths, String destDir, IProgressCallback cb) = 12;
    void setAllowBrowse(boolean allow) = 13;

    String[] listDetailed(String dir) = 14;
    void deletePaths(in String[] paths, String trashDir, IProgressCallback cb) = 15;
    boolean rename(String from, String to) = 16;
    long pathSize(String path) = 17;

    void backupXapk(in String[] jobs, IProgressCallback cb) = 18;

    void installApk(in String[] paths, IProgressCallback cb) = 19;
    void unzip(String zip, String destDir, IProgressCallback cb) = 20;
    void installBundle(String path, IProgressCallback cb) = 22;
    void zip(in String[] srcs, String outZip, IProgressCallback cb) = 21;
}
