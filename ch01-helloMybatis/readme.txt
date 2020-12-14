ch01-helloMybatis 入门例子

实现步骤：
    1.新建一个student表
    2.加入maven的mybatis坐标，mysql驱动坐标
    3.创建实体类，Student（保存表中一行数据）
    4.创建持久层的dao接口，定义操作数据库的方法
    5.创建一个mybatis使用的配置文件，sql映射文件（写sql语句的）
        一般一个表一个sql映射文件，一般是xml的文件。(文件在接口所在的目录中，文件名和接口保持一致)
    6.创建mybatis的主配置文件
        一个项目只有一个主配置文件（提供数据库的连接信息和映射文件的位置）
    7.通过mybatis访问数据文件

    基本步骤：
        1.加入maven依赖
        2.创建Dao接口：定义操作数据的方法
        3.创建mapper文件,也叫sql映射文件：写sql语句，和接口中方法对应的sql语句
        4.创建mabatis的主配置文件
            1.连接数据库
            2.指定mapper文件的位置
        5.使用mybatis对象sqlsession，通过她的方法执行sql语句