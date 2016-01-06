# Linux下文件误删除的操作
#### 第一种情况
当前系统有多个用户,其中一个用户对文件进行修改,则另一个用户对文件进行删除操作,那么这时候该如何操作?
*解决方法:*
通过文件打开的PID及打开的文件句柄

    lsof | grep -i delete 
    cp /proc/file_PID/fd/# /path/file_name

*-i 不区分大小写搜索*
 #为标志1的文件
 

#### 第二种情况
当前系统只有一个用户在登录,对文件进行了误删除操作,那么这个时候如何操作呢?
*注意事项及解决思路:*
1. 停止对当前分区进行修改
2. 通过dd命令进行对分区备份,防止通过第三方软件恢复失败,造成对数据的丢失

    dd if=/path/filename of /dev/sdb1

3. 通过umount命令将当前设备分区基于卸载
`umount /dev/sda或者umount /mount_poit`

4. 下载并安装第三方开源工具,进行搜索并进行还原

    ``` linux
    wget http://downloads.sourceforge.net/project/extundelete/extundelete/0.2.4/extundelete-0.2.4.tar.bz2
    或者
    apt-get install extundelete
    或者
    yun install  extundelete
    或者
    dnf install extundelete...... ```
    
5. 编译安装(不是wget下载的用户不用此步)
1. 源码包的解压
2. 相应的命令进行对源码文件配置属性

        ./configure 
        或者
        cmake
3. 编译,安装

        make
        make install
#####extundelete相关命令
    1. 搜索
        extundelete --inode 1 /dev/dm-0
    2. 恢复
        extundelete --restore-inode inode /dev/dm-0
        extundelete --restore-all /dev/dm-0
    3.文件,目录,时间 extundelete --help