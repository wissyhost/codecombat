# JAVA高级笔记
###### 作者:王永生
***

* #### 高础语法
1. ##### 反射:
	**在程序运行中(在类加载过程中),动态的知道类的信息(包.类,对象,属性,方法,构造器...etc)这就是反射机制**
    * 获取Class的几种方法

    ```Java
    String className1="java.lang.String";
    Class one=Class.forName(className1);
	Class two=String.class;
	Class three="abc".getClass();
	Class four=int.class;
	Class five=Void.class;
    ```
	* 与构造器有关的常见应用
		* Class
			方法:

            ```Java
            1. getConstructors();获取类中的所有public构造器Constructor[]
            2. getDeclaredConstructors();获取类中的所有构造器Constructor[]
            3. getConstructor(Class ...)获取一个构造器Constructor
            ```
		* Constructor:表示构造器
            `newInstance(Class ...) 通过构造器创建对象`
	* 与方法有关的常见应用
		* Method
			方法:

            ```Java
            1. getMethods();		//获取类中的所有public方法(包括父类)Method[]
            2. getDeclaredMethods();//获取类中的所有方法(只是自己的方法)Method[]
            3. getDeclaredMethod(Class ...)//获取一个指定方法method
            ```
            Method:表示构造器
            `invoke(,Object,Class ...) 执行指定对象的对应方法`
	* 与属性有关的常见应用
        * Field
            方法:

            ```Java
            1.getFields();			//获取类中的所有public属性Field[]
            2.getDeclaredFields();	//获取类中的所有属性Field[]
            3.getDeclaredField(Class ...)	//获取一个指定属性Field
            ```
		* Field:表示属性

		```Java
        set(Object  ,Object Value....)	//给对象属性赋值
        get(Object)			//获取指定对象的指定属性
        ```
2. ##### 线程与进程
	* 进程与线程
		1. 进程是操作系统分配的空间,进程又线程组成
		2. 进程所占内存空间独立,线程公用进程的内存空间
		3. 进程之间信息交换耗费资源大,线程之间信息共享开销低
	* 创建线程的两种方式
		1. 继承Thread类
			* 继承Thread类
			* 覆盖父类的run方法(线程体)
			* 数据部共享
		2. 实现Runnable接口
			* 实现Runnable接口
			* 覆盖Runnable接口中的run方法
			* 利用Thread(Runnable)构造器创建线程
			* 可以共享数据(Runnable接口实现的对象)
			* 可以有父类
	* 定义一个线程
        1. 继承自Thread类
        2. 重写run方法(线程体)
        3. 启动线程用start方法
	* 线程的5种状态
		* 新建
		* 可运行状态
		* 运行中
		* 阻塞
		* 死亡
	* 线程的生命周期
		1. 调用Thread类的构造器创建一个对象,线程进入新建状态
		2. 线程对象调用start方法,线程进入可运行状态
		3. 线程获得cpu执行资源,线程进入运行状态
		4. 线程运行时发生阻塞,线程进入阻塞状态,阻塞结束后,进入可运行状态
		5. 线程体执行结束,线程进入死亡状态
	* 描述等待队列和锁池
        * 正在运行的线程,如果调用wait()方法,会使对象所在的线程进入等待队列
        * 通过其他线程调用该对象的notity()方法可以唤醒一个线程,调用notityAll()方法唤醒全部线程,线程唤醒后进入锁池
        * 锁池中的线程执行结束后进入可运行状态
        * 正在运行的线程,如果调用yield()方法,会让出CPU资源等待队列,之后进入锁池,,最后回到可运行状态
        * 通过synchronization修饰的代码会自动进入死锁状态,称之为同步锁
	* 后台线程(守护线程):
        * **为所以非后台线程提供服务的线程,当所有非后台线程结束后,他会自动结束**
    * synchronizatized 表示同步
      1. 修饰代码块
      ```Java
       synchronizatized(锁){
           同步代码
       }
       ```
      2. 修饰方法
      ```Java
      synchronizatized void tt1(){
      	同步代码
      }
     ```
     3. 优缺点
          **优点:安全**
          **缺点:效率低**
	* 加锁
		**一般不用this 因为运行时不止一个this**
        * 加锁
        	1. class对象
        	2. 普通对象
    	* 定义一个类的锁   -->必须为引用数据类型
    	```Java
        static int[] c=new int[0]; -->>所以在程序中会有一个为空间0的变量
        //此时c就是锁
        ```
		* 锁级别:
        	* 每个对象都有一把锁,如果锁在静态的对象,
        	* 则锁是加在Class运行时的对象上的(有时也称之为静态锁)
		* 锁原理:
        	1. 具有不可分割的一些操作的业务逻辑,称之为原子操作
        	2. 对原子操作进行加锁
        	3. 锁类型,锁分为实例级别和静态级别
        	4. 当A线程进入锁区域,并且获得锁,具有执行能力,他会把锁状态从1变为0;
        	5. 当B进入锁区域,先检查锁状态,如果是0,说明锁在使用,进入等待状态;
        	6. 当B发现锁对象状态为1,则进入抢锁状态,如果抢到,执行4操作.
		* 单例模式:

		```Java
        class Singleton {
             // 定义一个静态变量用来返回
             private static Singleton instance;
            private static String key = "key";
             // 私有的构造方法,保证外部使用者不能创建实例
             private Singleton() {}
             // 提供一个公共的静态方法返回本类的实例
             public static Singleton getInstance() {
                 synchronized (key) {
                    if (instance == null) {
                     instance = new Singleton();
                     }
                 }
                return instance;
             }
        }
        ```
	* `wait()`、`notify()` 和 `notifyAll()`
		* Object 类定义了 `wait()`、`notify()` 和 `notifyAll()` 方法。可以让线程相互通知事件的发生。要执行这些方法，**必须拥有相关对象的锁**。wait() 会让调用线程休眠，直到用 Thread.interrupt() 中断它 或者wait经过了指定的时间 或者另一个线程用,notify() 或 notifyAll() 唤醒它.当对某个对象调用 notify() 时，如果有任何线程正在通过 wait() 等待该对象，那么就会唤醒其中一个线程。当对某个对象调用 notifyAll()时，会唤醒所有正在等待该对象的线程。
		* **wait、notify、notifyAll这三个方法只能在synchronized方法中调用，**即无论线程调用一个对象的wait还是notify方法，该线程必须先得到该对象的锁旗标，这样，notify只能唤醒同一对象监视器中调用wait的线程。
3. ##### 网络编程
	* CS与BS模式:
		&#160;&#160;**CS就是Client/Server,表示客户端连接服务器的程序 ,如QQ**
		&#160;&#160;**BS就是Browser/Server,表示浏览器连接服务器的程序 ,如新浪**
		1. CS要求客户机安装程序,由客户机分担一部分功能,可以缓解服务器压力
		2. BS不要求客户机安装程序,所有功能由服务器提供,服务器工作压力大
		3. BS比CS结构的项目更好推广
	* OSI七层结构
        * 物理层.主要提供网络简介的硬件支持,包括网卡网线
        * 数据链路层.提供数据通信的通道,协议等,只要表现为交换机等
        * 网络层.为物理设备提供网络地址,实现网络地址与物理地址之间的映射,如IP地址
        * 传输层.提供数据传输的要求,功能,如TCP,UDP
        * 回话层.提供点对点的连接,TCP建立连接有3次握手,断开连接有4次握手
        * 表示层.由于网络传输的数据很小,所有这层会对大数据进行分割,也提供数据加密的功能
        * 应用层.提供如http,ftp,mailTo等网络应用功能
	* TCP与UDP
        * 一个可靠一个不可靠
        * 一个差错控制开销大,一个差错控制开销小
        * 一个传输无限制,一个传输限制在64k以下
        * 一个需要连接建立,一个不需要建立连接
	* Scoket套接字
        * Scoket,客户端
        * ServerScoket服务端

        ```Java
        Socket client=new Socket("127.0.0.1",5000) //客户端
        ServerScoket service=new ServerScoket(5000) //服务端
        ```
	* InetAddress
        &#160;&#160;**表示网络地址,对象里面有ip地址信息和域名**
		* 常用方法:

		```Java
        getAllByName();   //获取指定对象上的InetAddress对象
        getHostAddress(); //获取InetAddress下的IP地址
        getHstName();     //获取InetAddress下的主机名
        ```
	* 编码集
        * GB2312&#9;&#160;&#160;简体中文
        * BIG5&#9;&#160;&#160;繁体中文
        * ISO8859-1&#9;&#160;&#160;英文
        * SHIFT-JIS&#9;&#160;&#160;日文
        * UTF-8&#9;&#160;&#160;国际通用字符集(包括世界上大多数国家的语言)
	* URL统一资源定位器
        * `URL badiu=new URL("http://~~~~~~/a.html)  //可以做爬虫了,哈哈!!`
        * 方法:

        ```Java
        openConnection() //获得URLConnection对象
        ```
	* URLConnection
        **表示URL资源的连接对象**
        * 常见方法:

        ```Java
        getInputStream()获得连接对象的输入流
        getOutputStream()获得连接对象的输出流
        ```

* #### JDBC
	**源码:JDBC:(src/JDBC/*)**
	**Jdbc就是Java Data Base Connection Java(数据库连接)**

* 数据库的连接方式(4种)
	1. Jdbc-Odbc桥接
       最早的java的连接数据库的方式
       **Jdbc-->Odbc-->Db**
       代表数据库:access
	1. Jdbc连接本地程序,本地程序连接远程数据库CS结构
       **Jdbc-->数据库客户端-->数据库服务器**
       代表数据库:db2
	1. Jdbc连接远程的web Service,web service 连接数据库,BS结构
       **Jdbc-->web服务器-->数据库**
	1. Jdbc直连
       **jdbc-->数据库**
       主流数据库都主持
       Sun公司提供数据库连接的接口,要求数据库厂商提供接口的实现类
       代表数据库:全部(除了access)
* Jdbc直连
	* Java提供接口
	* 数据库提供的实现类,打成jar包.提供给开发者
* 使用
	1. 找到mysql的架包
	2. 一般建议将包拷贝到当前的工程下
	3. 导入架包.右击工程-->属性-->java build path-->libraries-->add jars-->选取刚才的架包 ok
		在Referenced Libraries出现的"奶瓶就可以"
	4. java提供的接口
		注意!!除了Driver其余都使用java.sql下的类

        |Driver|DriverManager|Connection|Statement|PreparedStatement|CallableStatement|ResultSet|
		|------|-------------|-----------|--------|-----------------|-----------------|---------|
		|驱动|驱动管理器|数据库连接|普通的执行列表|预编译的执行列表|执行存储过程的列表|结果集|
		   Driver,DriverManager,Connection,Statement,PreparedStatement,CallableStatement,ResultSet
	5. Jdbc连接的步骤(step)
		1. 加载驱动
		    	Class.forName(包名.类名);  //反射
		    目的:加载类到运行时系统,并且能被DriverManager管理
		2. 获取数据库连接
		    * 需要知道URL(IP,端口号,数据库名称),用户名,密码
		  	**注意!!数据库不同,URL不同**
		    * Mysql的URL地址
		        * 如jdbc:mysql://127.0.0.1:3306/test
		        * 如jdbc:mysql://127.0.0.1:3306?test或者其他非重要字段
                * 其他字段如字符集:`?useUnicode=true&characterEncoding=UTF-8`在中文乱码时使用
		        127.0.0.1:数据库地址
		        3306:Mysql的默认端口
		        test:数据库名称
		    * Connection 数据库连接对象
		    ```Java
               DriverManager.getConnection(URL,user,passwd);
			```
		4. Statement 获取Statement,执行Sql语句的客户端
 			* 获取Statement的方法
 			```Java
            连接名的.createStatement();
			```
   			* 这个对象主要功能是存放SQL的执行列表
		4. 往列表中装SQL语句
			* sql语句不需要写";"
			* 一次中放一个SQL语句
			* executeUpdate 主要执行DML语句(insert ,update,delete)语句,**返回值是影响的行数**
			* executeQuery 主要执行DQL语句,**返回值是ResultSet结果集**
			* 书写顺序:
			`select ,from ,where,group by,having, order by,limit`
			* ResultSet方法
              **注意!!数据库连接关闭,ResultSet将会为null**
               ```Java
			next(),表示如果有记录就,移动记录到下一条.如果是到了最后一条,返回false
			getObject(int 索引),索引从1开始
			getObject(String 字段名)		//可以得到列的值
			getString();
			getInt();
			getFloat();
			getDate();这个Date是java.sql.Date;
			....
               ```
		5. 关闭数据库连接
         	**先关Statement,后关Connection**
* JDBC连接的第三步的扩展
	* statement
	* PreparedStatement 可预处理的Statement
	  **?表示一个变量,?有索引,索引从1开始**
	* CallableStatement,可呼叫的Statement,通常用在数据库的存储过程
	* PreparedStatement与Statement的区别
		1. PreparedStatement是Statement的子接口
		2. Statement在创建对象时不放sql语句,PreparedStatement在创建时要加入预处理的sql语句
		3. Statement的sql不能有变量.PreparedStatement可以用?变量
		4. 对单一的sql执行效率,PreparedStatement效率高
		5. 安全上.PreparedStatement防止SQL注入的发生

	**SQL注入:select * from user where username='tom' and passwd='122'**
    **如果: tom -->' or  '1' = '1**  会返回多少条记录
* JDBC事务与批处理:
	* **事务步骤:**
		1. connection.SetAutoCommit(false);//事务开启
		2. connection.commit();事务提交
		3. connection.rollback();事务回滚
	* 批处理
		* 批处理:配合PreparedStatement和事务进行会更好
		* 批处理一般用于Insert语句
		* 插入n条语句
		* 返回一个int类型的数组;1成功,0失败.可以进行数据统计,准确率:数值相加/长度  错误率:(长度-相加的数值)/长度

#### SQL语法
**详见SQL语句.md**

