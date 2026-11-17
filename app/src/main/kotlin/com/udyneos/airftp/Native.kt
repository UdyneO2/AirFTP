package com.udyneos.airftp

object Native {
    init { System.loadLibrary("airftp") }

    @JvmStatic external fun initGl(density: Float)
    @JvmStatic external fun render(w: Int, h: Int)
    @JvmStatic external fun touch(action: Int, x: Float, y: Float)
    @JvmStatic external fun pollAction(): String
    @JvmStatic external fun log(msg: String)

    @JvmStatic external fun setShizuku(ok: Boolean, msg: String)
    @JvmStatic external fun setShizukuFailed(failed: Boolean)
    @JvmStatic external fun setUpdateMsg(msg: String)
    @JvmStatic external fun tr(s: String): String

    @JvmStatic external fun setFonts(regular: ByteArray?, bold: ByteArray?)
    @JvmStatic external fun selectTab(idx: Int)

    @JvmStatic external fun back(): Boolean

    @JvmStatic external fun setPreview(w: Int, h: Int, buf: java.nio.ByteBuffer?, name: String, idx: Int, cnt: Int, msg: String)
    @JvmStatic external fun closePreview()
    @JvmStatic external fun setSettings(dark: Boolean, hidden: Boolean, trash: Boolean, xapkDir: String, devName: String, instShizuku: Boolean, autoUpdate: Boolean, lang: String, sysLang: String)

    @JvmStatic external fun setFm(
        path: String, err: String, filter: String, sort: Int, asc: Boolean,
        names: Array<String>, sizes: LongArray, dirs: BooleanArray, mtimes: LongArray
    )
    @JvmStatic external fun setClip(count: Int, cut: Boolean)
    @JvmStatic external fun setFmProgress(busy: Boolean, done: Long, total: Long, speed: Double, cur: String)

    @JvmStatic external fun setApps(filter: String, names: Array<String>, subs: Array<String>, sizes: LongArray)
    @JvmStatic external fun setApkProgress(busy: Boolean, done: Long, total: Long, speed: Double, cur: String)

    @JvmStatic external fun setNetPerm(ok: Boolean, msg: String)
    @JvmStatic external fun setPeers(names: Array<String>)
    @JvmStatic external fun setTargets(names: Array<String>, states: IntArray, on: BooleanArray, active: Int)
    @JvmStatic external fun setNetInfo(addr: String, pin: String, recvDir: String, listening: Boolean, paired: String)
    @JvmStatic external fun setSendList(names: Array<String>, sizes: LongArray)
    @JvmStatic external fun setNetProgress(busy: Boolean, done: Long, total: Long, speed: Double, cur: String)

    @JvmStatic external fun setPane(
        idx: Int, path: String, remote: Boolean, err: String,
        names: Array<String>, sizes: LongArray, dirs: BooleanArray
    )
    @JvmStatic external fun setBookmarks(paths: Array<String>)
    @JvmStatic external fun setFtpProgress(busy: Boolean, done: Long, total: Long, speed: Double, cur: String)

    @JvmStatic external fun setBrowser(
        open: Boolean, purpose: Int, path: String,
        names: Array<String>, sizes: LongArray, dirs: BooleanArray
    )
}
