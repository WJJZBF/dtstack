package com.dtstack.generate_data.controller;

import com.dtstack.generate_data.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author moyuan
 * @since 2019/2/21
 */
@RestController
public class Controller {
    @RequestMapping("/generateData")
    public ResponseEntity<String> generateDate() {
//        testThread();
//        try {
//            insertMysql();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return ResponseEntity.ok("已开启新线程执行任务");
    }


    public void testThread() {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
//                        createMysqlTable();
//                        insertMuchMysqlTable();
//                        insertSqlServer();
//                        insertPostgreSql();
//                        insertMysql();
//                        updateTable();
                        insertTable2();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public Connection getCon() {
        String driver_oracle = "oracle.jdbc.driver.OracleDriver";
        String url_oracle = "jdbc:oracle:thin:@//172.16.8.193:1521/orcl";
        String user_oracle = "ROOT";
        String password_oracle = "123456";

        String driver_mysql = "com.mysql.cj.jdbc.Driver";
        String url_mysql = "jdbc:mysql://172.16.8.193:3306/DTstack";
        String user_mysql = "root";
        String password_mysql = "123456";

        String driver_sqlserver = "net.sourceforge.jtds.jdbc.Driver";
        String url_sqlserver = "jdbc:jtds:sqlserver://172.16.8.149:1433;DatabaseName=DTstack";
        String user_sqlserver = "sa";
        String password_sqlserver = "Dtstack2018";

        String driver_postgresql = "org.postgresql.Driver";
        String url_postgresql = "jdbc:postgresql://172.16.8.193:5432/DTstack";
        String user_postgresql = "root";
        String password_postgresql = "123456";
        try {
            Class.forName(driver_mysql);
            Connection conn = DriverManager.getConnection(url_mysql, user_mysql, password_mysql);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertTable1() throws SQLException {
        Connection con = null;
        long start_time = 0;
        List<Employee> employees = getDatas(10000000);
        try {
            con = getCon();
            start_time = System.currentTimeMillis();
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(" INSERT /*+ append */ INTO EMPLOYEE1 (ID,DEPTNO,EMPNO,ENAME,JOB,SAL,HIREDATE,LANGUAGE19,HEALTH,CHARACTER19,ID0,DEPTNO0,EMPNO0,ENAME0,JOB0,SAL0,HIREDATE0,LANGUAGE0,HEALTH0,CHARACTER0,ID1,DEPTNO1,EMPNO1,ENAME1,JOB1,SAL1,HIREDATE1,LANGUAGE1,HEALTH1,CHARACTER1,ID2,DEPTNO2,EMPNO2,ENAME2,JOB2,SAL2,HIREDATE2,LANGUAGE2,HEALTH2,CHARACTER2,ID3,DEPTNO3,EMPNO3,ENAME3,JOB3,SAL3,HIREDATE3,LANGUAGE3,HEALTH3,CHARACTER3,ID4,DEPTNO4,EMPNO4,ENAME4,JOB4,SAL4,HIREDATE4,LANGUAGE4,HEALTH4,CHARACTER4,ID5,DEPTNO5,EMPNO5,ENAME5,JOB5,SAL5,HIREDATE5,LANGUAGE5,HEALTH5,CHARACTER5,ID6,DEPTNO6,EMPNO6,ENAME6,JOB6,SAL6,HIREDATE6,LANGUAGE6,HEALTH6,CHARACTER6,ID7,DEPTNO7,EMPNO7,ENAME7,JOB7,SAL7,HIREDATE7,LANGUAGE7,HEALTH7,CHARACTER7,ID8,DEPTNO8,EMPNO8,ENAME8,JOB8,SAL8,HIREDATE8,LANGUAGE8,HEALTH8,CHARACTER8,ID9,DEPTNO9,EMPNO9,ENAME9,JOB9,SAL9,HIREDATE9,LANGUAGE9,HEALTH9,CHARACTER9,ID10,DEPTNO10,EMPNO10,ENAME10,JOB10,SAL10,HIREDATE10,LANGUAGE10,HEALTH10,CHARACTER10,ID11,DEPTNO11,EMPNO11,ENAME11,JOB11,SAL11,HIREDATE11,LANGUAGE11,HEALTH11,CHARACTER11,ID12,DEPTNO12,EMPNO12,ENAME12,JOB12,SAL12,HIREDATE12,LANGUAGE12,HEALTH12,CHARACTER12,ID13,DEPTNO13,EMPNO13,ENAME13,JOB13,SAL13,HIREDATE13,LANGUAGE13,HEALTH13,CHARACTER13,ID14,DEPTNO14,EMPNO14,ENAME14,JOB14,SAL14,HIREDATE14,LANGUAGE14,HEALTH14,CHARACTER14,ID15,DEPTNO15,EMPNO15,ENAME15,JOB15,SAL15,HIREDATE15,LANGUAGE15,HEALTH15,CHARACTER15,ID16,DEPTNO16,EMPNO16,ENAME16,JOB16,SAL16,HIREDATE16,LANGUAGE16,HEALTH16,CHARACTER16,ID17,DEPTNO17,EMPNO17,ENAME17,JOB17,SAL17,HIREDATE17,LANGUAGE17,HEALTH17,CHARACTER17,ID18,DEPTNO18,EMPNO18,ENAME18,JOB18,SAL18,HIREDATE18,LANGUAGE18,HEALTH18,CHARACTER18) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            long num = 0;
            for (int i = 0; i < employees.size(); i++) {

                Employee emp = employees.get(i);

                statement.setString(1, UUID.randomUUID().toString());
                statement.setInt(2, emp.getDeptNo());
                statement.setInt(3, emp.getEmpNo());
                statement.setString(4, emp.geteName());
                statement.setString(5, emp.getJob());
                statement.setFloat(6, emp.getSal());
                statement.setInt(7, emp.getHireDate());
                statement.setString(8, emp.getLanguage());
                statement.setInt(9, emp.getHealth());
                statement.setString(10, emp.getCharacter());

                statement.setInt(11, emp.getId0());
                statement.setInt(12, emp.getDeptNo0());
                statement.setInt(13, emp.getEmpNo0());
                statement.setString(14, emp.geteName0());
                statement.setString(15, emp.getJob0());
                statement.setFloat(16, emp.getSal0());
                statement.setInt(17, emp.getHireDate0());
                statement.setString(18, emp.getLanguage0());
                statement.setInt(19, emp.getHealth0());
                statement.setString(20, emp.getCharacter0());

                statement.setInt(21, emp.getId1());
                statement.setInt(22, emp.getDeptNo1());
                statement.setInt(23, emp.getEmpNo1());
                statement.setString(24, emp.geteName1());
                statement.setString(25, emp.getJob1());
                statement.setFloat(26, emp.getSal1());
                statement.setInt(27, emp.getHireDate1());
                statement.setString(28, emp.getLanguage1());
                statement.setInt(29, emp.getHealth1());
                statement.setString(30, emp.getCharacter1());

                statement.setInt(31, emp.getId2());
                statement.setInt(32, emp.getDeptNo2());
                statement.setInt(33, emp.getEmpNo2());
                statement.setString(34, emp.geteName2());
                statement.setString(35, emp.getJob2());
                statement.setFloat(36, emp.getSal2());
                statement.setInt(37, emp.getHireDate2());
                statement.setString(38, emp.getLanguage2());
                statement.setInt(39, emp.getHealth2());
                statement.setString(40, emp.getCharacter2());

                statement.setInt(41, emp.getId3());
                statement.setInt(42, emp.getDeptNo3());
                statement.setInt(43, emp.getEmpNo3());
                statement.setString(44, emp.geteName3());
                statement.setString(45, emp.getJob3());
                statement.setFloat(46, emp.getSal3());
                statement.setInt(47, emp.getHireDate3());
                statement.setString(48, emp.getLanguage3());
                statement.setInt(49, emp.getHealth3());
                statement.setString(50, emp.getCharacter3());

                statement.setInt(51, emp.getId4());
                statement.setInt(52, emp.getDeptNo4());
                statement.setInt(53, emp.getEmpNo4());
                statement.setString(54, emp.geteName4());
                statement.setString(55, emp.getJob4());
                statement.setFloat(56, emp.getSal4());
                statement.setInt(57, emp.getHireDate4());
                statement.setString(58, emp.getLanguage4());
                statement.setInt(59, emp.getHealth4());
                statement.setString(60, emp.getCharacter4());

                statement.setInt(61, emp.getId5());
                statement.setInt(62, emp.getDeptNo5());
                statement.setInt(63, emp.getEmpNo5());
                statement.setString(64, emp.geteName5());
                statement.setString(65, emp.getJob5());
                statement.setFloat(66, emp.getSal5());
                statement.setInt(67, emp.getHireDate5());
                statement.setString(68, emp.getLanguage5());
                statement.setInt(69, emp.getHealth5());
                statement.setString(70, emp.getCharacter5());

                statement.setInt(71, emp.getId6());
                statement.setInt(72, emp.getDeptNo6());
                statement.setInt(73, emp.getEmpNo6());
                statement.setString(74, emp.geteName6());
                statement.setString(75, emp.getJob6());
                statement.setFloat(76, emp.getSal6());
                statement.setInt(77, emp.getHireDate6());
                statement.setString(78, emp.getLanguage6());
                statement.setInt(79, emp.getHealth6());
                statement.setString(80, emp.getCharacter6());

                statement.setInt(81, emp.getId7());
                statement.setInt(82, emp.getDeptNo7());
                statement.setInt(83, emp.getEmpNo7());
                statement.setString(84, emp.geteName7());
                statement.setString(85, emp.getJob7());
                statement.setFloat(86, emp.getSal7());
                statement.setInt(87, emp.getHireDate7());
                statement.setString(88, emp.getLanguage7());
                statement.setInt(89, emp.getHealth7());
                statement.setString(90, emp.getCharacter7());

                statement.setInt(91, emp.getId8());
                statement.setInt(92, emp.getDeptNo8());
                statement.setInt(93, emp.getEmpNo8());
                statement.setString(94, emp.geteName8());
                statement.setString(95, emp.getJob8());
                statement.setFloat(96, emp.getSal8());
                statement.setInt(97, emp.getHireDate8());
                statement.setString(98, emp.getLanguage8());
                statement.setInt(99, emp.getHealth8());
                statement.setString(100, emp.getCharacter8());


                statement.setInt(101, emp.getId9());
                statement.setInt(102, emp.getDeptNo9());
                statement.setInt(103, emp.getEmpNo9());
                statement.setString(104, emp.geteName9());
                statement.setString(105, emp.getJob9());
                statement.setFloat(106, emp.getSal9());
                statement.setInt(107, emp.getHireDate9());
                statement.setString(108, emp.getLanguage9());
                statement.setInt(109, emp.getHealth9());
                statement.setString(110, emp.getCharacter9());


                statement.setInt(111, emp.getId10());
                statement.setInt(112, emp.getDeptNo10());
                statement.setInt(113, emp.getEmpNo10());
                statement.setString(114, emp.geteName10());
                statement.setString(115, emp.getJob10());
                statement.setFloat(116, emp.getSal10());
                statement.setInt(117, emp.getHireDate10());
                statement.setString(118, emp.getLanguage10());
                statement.setInt(119, emp.getHealth10());
                statement.setString(120, emp.getCharacter10());

                statement.setInt(121, emp.getId11());
                statement.setInt(122, emp.getDeptNo11());
                statement.setInt(123, emp.getEmpNo11());
                statement.setString(124, emp.geteName11());
                statement.setString(125, emp.getJob11());
                statement.setFloat(126, emp.getSal11());
                statement.setInt(127, emp.getHireDate11());
                statement.setString(128, emp.getLanguage11());
                statement.setInt(129, emp.getHealth12());
                statement.setString(130, emp.getCharacter12());

                statement.setInt(131, emp.getId12());
                statement.setInt(132, emp.getDeptNo12());
                statement.setInt(133, emp.getEmpNo12());
                statement.setString(134, emp.geteName12());
                statement.setString(135, emp.getJob12());
                statement.setFloat(136, emp.getSal12());
                statement.setInt(137, emp.getHireDate12());
                statement.setString(138, emp.getLanguage12());
                statement.setInt(139, emp.getHealth12());
                statement.setString(140, emp.getCharacter12());

                statement.setInt(141, emp.getId13());
                statement.setInt(142, emp.getDeptNo13());
                statement.setInt(143, emp.getEmpNo13());
                statement.setString(144, emp.geteName13());
                statement.setString(145, emp.getJob13());
                statement.setFloat(146, emp.getSal13());
                statement.setInt(147, emp.getHireDate13());
                statement.setString(148, emp.getLanguage13());
                statement.setInt(149, emp.getHealth13());
                statement.setString(150, emp.getCharacter13());

                statement.setInt(151, emp.getId14());
                statement.setInt(152, emp.getDeptNo14());
                statement.setInt(153, emp.getEmpNo14());
                statement.setString(154, emp.geteName14());
                statement.setString(155, emp.getJob14());
                statement.setFloat(156, emp.getSal14());
                statement.setInt(157, emp.getHireDate14());
                statement.setString(158, emp.getLanguage14());
                statement.setInt(159, emp.getHealth14());
                statement.setString(160, emp.getCharacter14());

                statement.setInt(161, emp.getId15());
                statement.setInt(162, emp.getDeptNo15());
                statement.setInt(163, emp.getEmpNo15());
                statement.setString(164, emp.geteName15());
                statement.setString(165, emp.getJob15());
                statement.setFloat(166, emp.getSal15());
                statement.setInt(167, emp.getHireDate15());
                statement.setString(168, emp.getLanguage15());
                statement.setInt(169, emp.getHealth15());
                statement.setString(170, emp.getCharacter15());

                statement.setInt(171, emp.getId16());
                statement.setInt(172, emp.getDeptNo16());
                statement.setInt(173, emp.getEmpNo16());
                statement.setString(174, emp.geteName16());
                statement.setString(175, emp.getJob16());
                statement.setFloat(176, emp.getSal16());
                statement.setInt(177, emp.getHireDate16());
                statement.setString(178, emp.getLanguage16());
                statement.setInt(179, emp.getHealth16());
                statement.setString(180, emp.getCharacter16());

                statement.setInt(181, emp.getId17());
                statement.setInt(182, emp.getDeptNo17());
                statement.setInt(183, emp.getEmpNo17());
                statement.setString(184, emp.geteName17());
                statement.setString(185, emp.getJob17());
                statement.setFloat(186, emp.getSal17());
                statement.setInt(187, emp.getHireDate17());
                statement.setString(188, emp.getLanguage17());
                statement.setInt(189, emp.getHealth17());
                statement.setString(190, emp.getCharacter17());

                statement.setInt(191, emp.getId18());
                statement.setInt(192, emp.getDeptNo18());
                statement.setInt(193, emp.getEmpNo18());
                statement.setString(194, emp.geteName18());
                statement.setString(195, emp.getJob18());
                statement.setFloat(196, emp.getSal18());
                statement.setInt(197, emp.getHireDate18());
                statement.setString(198, emp.getLanguage18());
                statement.setInt(199, emp.getHealth18());
                statement.setString(200, emp.getCharacter18());

                statement.addBatch();
                num++;
                if (num != 0 && num % 2000 == 0) {
                    statement.executeBatch();
                    con.commit();
                    statement.clearBatch();
                    num = 0;
                }
            }
            statement.executeBatch();
            con.commit();
            employees.clear();

        } catch (
                Exception e)

        {
            e.printStackTrace();
            con.rollback();
        } finally

        {
            if (con != null) {
                con.close();
            }
            long end_time = System.currentTimeMillis();

            System.out.println("共执行" + (end_time - start_time) + "ms");
        }


    }

    public void insertTable2() throws SQLException {
        Connection connection = null;
        int count = 100000000;
        long start_time = 0;
        try {
            connection = getCon();
            start_time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(" INSERT  /*+ append parallel(a, 4) nologging */ INTO EMPLOYEE2 a(ID,DEPTNO,EMPNO,ENAME,JOB,SAL,HIREDATE,LANGUAGE19,HEALTH,CHARACTER19,ID0,DEPTNO0,EMPNO0,ENAME0,JOB0,SAL0,HIREDATE0,LANGUAGE0,HEALTH0,CHARACTER0,ID1,DEPTNO1,EMPNO1,ENAME1,JOB1,SAL1,HIREDATE1,LANGUAGE1,HEALTH1,CHARACTER1,ID2,DEPTNO2,EMPNO2,ENAME2,JOB2,SAL2,HIREDATE2,LANGUAGE2,HEALTH2,CHARACTER2,ID3,DEPTNO3,EMPNO3,ENAME3,JOB3,SAL3,HIREDATE3,LANGUAGE3,HEALTH3,CHARACTER3,ID4,DEPTNO4,EMPNO4,ENAME4,JOB4,SAL4,HIREDATE4,LANGUAGE4,HEALTH4,CHARACTER4,ID5,DEPTNO5,EMPNO5,ENAME5,JOB5,SAL5,HIREDATE5,LANGUAGE5,HEALTH5,CHARACTER5,ID6,DEPTNO6,EMPNO6,ENAME6,JOB6,SAL6,HIREDATE6,LANGUAGE6,HEALTH6,CHARACTER6,ID7,DEPTNO7,EMPNO7,ENAME7,JOB7,SAL7,HIREDATE7,LANGUAGE7,HEALTH7,CHARACTER7,ID8,DEPTNO8,EMPNO8,ENAME8,JOB8,SAL8,HIREDATE8,LANGUAGE8,HEALTH8,CHARACTER8,ID9,DEPTNO9,EMPNO9,ENAME9,JOB9,SAL9,HIREDATE9,LANGUAGE9,HEALTH9,CHARACTER9,ID10,DEPTNO10,EMPNO10,ENAME10,JOB10,SAL10,HIREDATE10,LANGUAGE10,HEALTH10,CHARACTER10,ID11,DEPTNO11,EMPNO11,ENAME11,JOB11,SAL11,HIREDATE11,LANGUAGE11,HEALTH11,CHARACTER11,ID12,DEPTNO12,EMPNO12,ENAME12,JOB12,SAL12,HIREDATE12,LANGUAGE12,HEALTH12,CHARACTER12,ID13,DEPTNO13,EMPNO13,ENAME13,JOB13,SAL13,HIREDATE13,LANGUAGE13,HEALTH13,CHARACTER13,ID14,DEPTNO14,EMPNO14,ENAME14,JOB14,SAL14,HIREDATE14,LANGUAGE14,HEALTH14,CHARACTER14,ID15,DEPTNO15,EMPNO15,ENAME15,JOB15,SAL15,HIREDATE15,LANGUAGE15,HEALTH15,CHARACTER15,ID16,DEPTNO16,EMPNO16,ENAME16,JOB16,SAL16,HIREDATE16,LANGUAGE16,HEALTH16,CHARACTER16,ID17,DEPTNO17,EMPNO17,ENAME17,JOB17,SAL17,HIREDATE17,LANGUAGE17,HEALTH17,CHARACTER17,ID18,DEPTNO18,EMPNO18,ENAME18,JOB18,SAL18,HIREDATE18,LANGUAGE18,HEALTH18,CHARACTER18,CREATETIME) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            long number = 0;
            for (int i = 0; i < count; i++) {
                System.out.println("第" + i + "次");
                int arg_id = (int) (100000 + Math.random() * 1000000000);
                int arg_deptNo = (int) (100 + Math.random() * 100000);
                int arg_empNo = (int) (10000 + Math.random() * 2000000000);
                String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
                String arg_job = "job_" + getRamdomDataASC(3);
                Float arg_sal = (float) (1000 + Math.random() * 1000000000);
                int arg_hireDate = (int) (20160101 + Math.random() * 1130);
                String arg_language = "language_" + getRamdomDataASC(5);
                int arg_health = (int) (Math.random() * 2);
                String arg_character = "character_" + getRamdomDataASC(7);
                long current_time = System.currentTimeMillis();


                statement.setString(1, UUID.randomUUID().toString());
                statement.setInt(2, arg_deptNo);
                statement.setInt(3, arg_empNo);
                statement.setString(4, arg_eName);
                statement.setString(5, arg_job);
                statement.setFloat(6, arg_sal);
                statement.setInt(7, arg_hireDate);
                statement.setString(8, arg_language);
                statement.setInt(9, arg_health);
                statement.setString(10, arg_character);

                statement.setInt(11, arg_id);
                statement.setInt(12, arg_deptNo);
                statement.setInt(13, arg_empNo);
                statement.setString(14, arg_eName);
                statement.setString(15, arg_job);
                statement.setFloat(16, arg_sal);
                statement.setInt(17, arg_hireDate);
                statement.setString(18, arg_language);
                statement.setInt(19, arg_health);
                statement.setString(20, arg_character);

                statement.setInt(21, arg_id);
                statement.setInt(22, arg_deptNo);
                statement.setInt(23, arg_empNo);
                statement.setString(24, arg_eName);
                statement.setString(25, arg_job);
                statement.setFloat(26, arg_sal);
                statement.setInt(27, arg_hireDate);
                statement.setString(28, arg_language);
                statement.setInt(29, arg_health);
                statement.setString(30, arg_character);

                statement.setInt(31, arg_id);
                statement.setInt(32, arg_deptNo);
                statement.setInt(33, arg_empNo);
                statement.setString(34, arg_eName);
                statement.setString(35, arg_job);
                statement.setFloat(36, arg_sal);
                statement.setInt(37, arg_hireDate);
                statement.setString(38, arg_language);
                statement.setInt(39, arg_health);
                statement.setString(40, arg_character);

                statement.setInt(41, arg_id);
                statement.setInt(42, arg_deptNo);
                statement.setInt(43, arg_empNo);
                statement.setString(44, arg_eName);
                statement.setString(45, arg_job);
                statement.setFloat(46, arg_sal);
                statement.setInt(47, arg_hireDate);
                statement.setString(48, arg_language);
                statement.setInt(49, arg_health);
                statement.setString(50, arg_character);

                statement.setInt(51, arg_id);
                statement.setInt(52, arg_deptNo);
                statement.setInt(53, arg_empNo);
                statement.setString(54, arg_eName);
                statement.setString(55, arg_job);
                statement.setFloat(56, arg_sal);
                statement.setInt(57, arg_hireDate);
                statement.setString(58, arg_language);
                statement.setInt(59, arg_health);
                statement.setString(60, arg_character);

                statement.setInt(61, arg_id);
                statement.setInt(62, arg_deptNo);
                statement.setInt(63, arg_empNo);
                statement.setString(64, arg_eName);
                statement.setString(65, arg_job);
                statement.setFloat(66, arg_sal);
                statement.setInt(67, arg_hireDate);
                statement.setString(68, arg_language);
                statement.setInt(69, arg_health);
                statement.setString(70, arg_character);

                statement.setInt(71, arg_id);
                statement.setInt(72, arg_deptNo);
                statement.setInt(73, arg_empNo);
                statement.setString(74, arg_eName);
                statement.setString(75, arg_job);
                statement.setFloat(76, arg_sal);
                statement.setInt(77, arg_hireDate);
                statement.setString(78, arg_language);
                statement.setInt(79, arg_health);
                statement.setString(80, arg_character);

                statement.setInt(81, arg_id);
                statement.setInt(82, arg_deptNo);
                statement.setInt(83, arg_empNo);
                statement.setString(84, arg_eName);
                statement.setString(85, arg_job);
                statement.setFloat(86, arg_sal);
                statement.setInt(87, arg_hireDate);
                statement.setString(88, arg_language);
                statement.setInt(89, arg_health);
                statement.setString(90, arg_character);

                statement.setInt(91, arg_id);
                statement.setInt(92, arg_deptNo);
                statement.setInt(93, arg_empNo);
                statement.setString(94, arg_eName);
                statement.setString(95, arg_job);
                statement.setFloat(96, arg_sal);
                statement.setInt(97, arg_hireDate);
                statement.setString(98, arg_language);
                statement.setInt(99, arg_health);
                statement.setString(100, arg_character);


                statement.setInt(101, arg_id);
                statement.setInt(102, arg_deptNo);
                statement.setInt(103, arg_empNo);
                statement.setString(104, arg_eName);
                statement.setString(105, arg_job);
                statement.setFloat(106, arg_sal);
                statement.setInt(107, arg_hireDate);
                statement.setString(108, arg_language);
                statement.setInt(109, arg_health);
                statement.setString(110, arg_character);


                statement.setInt(111, arg_id);
                statement.setInt(112, arg_deptNo);
                statement.setInt(113, arg_empNo);
                statement.setString(114, arg_eName);
                statement.setString(115, arg_job);
                statement.setFloat(116, arg_sal);
                statement.setInt(117, arg_hireDate);
                statement.setString(118, arg_language);
                statement.setInt(119, arg_health);
                statement.setString(120, arg_character);

                statement.setInt(121, arg_id);
                statement.setInt(122, arg_deptNo);
                statement.setInt(123, arg_empNo);
                statement.setString(124, arg_eName);
                statement.setString(125, arg_job);
                statement.setFloat(126, arg_sal);
                statement.setInt(127, arg_hireDate);
                statement.setString(128, arg_language);
                statement.setInt(129, arg_health);
                statement.setString(130, arg_character);

                statement.setInt(131, arg_id);
                statement.setInt(132, arg_deptNo);
                statement.setInt(133, arg_empNo);
                statement.setString(134, arg_eName);
                statement.setString(135, arg_job);
                statement.setFloat(136, arg_sal);
                statement.setInt(137, arg_hireDate);
                statement.setString(138, arg_language);
                statement.setInt(139, arg_health);
                statement.setString(140, arg_character);

                statement.setInt(141, arg_id);
                statement.setInt(142, arg_deptNo);
                statement.setInt(143, arg_empNo);
                statement.setString(144, arg_eName);
                statement.setString(145, arg_job);
                statement.setFloat(146, arg_sal);
                statement.setInt(147, arg_hireDate);
                statement.setString(148, arg_language);
                statement.setInt(149, arg_health);
                statement.setString(150, arg_character);

                statement.setInt(151, arg_id);
                statement.setInt(152, arg_deptNo);
                statement.setInt(153, arg_empNo);
                statement.setString(154, arg_eName);
                statement.setString(155, arg_job);
                statement.setFloat(156, arg_sal);
                statement.setInt(157, arg_hireDate);
                statement.setString(158, arg_language);
                statement.setInt(159, arg_health);
                statement.setString(160, arg_character);

                statement.setInt(161, arg_id);
                statement.setInt(162, arg_deptNo);
                statement.setInt(163, arg_empNo);
                statement.setString(164, arg_eName);
                statement.setString(165, arg_job);
                statement.setFloat(166, arg_sal);
                statement.setInt(167, arg_hireDate);
                statement.setString(168, arg_language);
                statement.setInt(169, arg_health);
                statement.setString(170, arg_character);

                statement.setInt(171, arg_id);
                statement.setInt(172, arg_deptNo);
                statement.setInt(173, arg_empNo);
                statement.setString(174, arg_eName);
                statement.setString(175, arg_job);
                statement.setFloat(176, arg_sal);
                statement.setInt(177, arg_hireDate);
                statement.setString(178, arg_language);
                statement.setInt(179, arg_health);
                statement.setString(180, arg_character);

                statement.setInt(181, arg_id);
                statement.setInt(182, arg_deptNo);
                statement.setInt(183, arg_empNo);
                statement.setString(184, arg_eName);
                statement.setString(185, arg_job);
                statement.setFloat(186, arg_sal);
                statement.setInt(187, arg_hireDate);
                statement.setString(188, arg_language);
                statement.setInt(189, arg_health);
                statement.setString(190, arg_character);

                statement.setInt(191, arg_id);
                statement.setInt(192, arg_deptNo);
                statement.setInt(193, arg_empNo);
                statement.setString(194, arg_eName);
                statement.setString(195, arg_job);
                statement.setFloat(196, arg_sal);
                statement.setInt(197, arg_hireDate);
                statement.setString(198, arg_language);
                statement.setInt(199, arg_health);
                statement.setString(200, arg_character);

                statement.setLong(201, current_time);


                statement.addBatch();
                number++;
                if (number != 0 && number % 1000 == 0) {
                    statement.executeBatch();
                    connection.commit();
                    statement.clearBatch();
                    number = 0;
                }

            }
            statement.executeBatch();
            connection.commit();


        } catch (
                Exception e)

        {
            e.printStackTrace();
            connection.rollback();
        } finally

        {
            if (connection != null) {
                connection.close();
            }
            long end_time = System.currentTimeMillis();

            System.out.println("共执行" + (end_time - start_time) + "ms");
        }


    }

    public void updateTable() throws SQLException {
        Connection connection = null;
        int count = 10;
        try {
            connection = getCon();
            connection.setAutoCommit(false);
            SimpleDateFormat date_formate = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement statement = connection.prepareStatement("update EMPLOYEE3 set CREATETIME=?,CREATETIME0=?,CREATETIME1=? where CREATETIME=null or CREATETIME0=null or CREATETIME1=null");
            for (int i = 0; i < count; i++) {
                System.out.println("写入数据");
                String create_time = "2018-" + (int) (1 + Math.random() * 11) + "-" + (int) (1 + Math.random() * 20) + " 00:00:00";
                Date create_time0 = new Date(date_formate.parse(create_time).getTime());
                Timestamp create_time1 = new Timestamp(create_time0.getTime());
                statement.setString(1, create_time);
                statement.setDate(2, create_time0);
                statement.setTimestamp(3, create_time1);
                statement.addBatch();
                if (i != 0 && i % 1000 == 0) {
                    statement.executeBatch();
                    connection.commit();
                    statement.clearBatch();
                }

            }
            statement.executeBatch();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            if (connection != null) {
                connection.close();

            }
        }
    }

    public void createMysqlTable() throws SQLException {
        Connection con = null;
        try {
            con = getCon();
            con.setAutoCommit(false);
            for (int i = 0; i < 150; i++) {
                String sql_create = "CREATE TABLE `employee_" + i + "` (\n" +
                        "  `id` varchar(36) DEFAULT NULL,\n" +
                        "  `deptno` int(10) DEFAULT NULL,\n" +
                        "  `empno` int(10) DEFAULT NULL,\n" +
                        "  `ename` varchar(32) DEFAULT NULL,\n" +
                        "  `job` varchar(32) DEFAULT NULL,\n" +
                        "  `sal` float DEFAULT NULL,\n" +
                        "  `hiredate` int(10) DEFAULT NULL,\n" +
                        "  `language19` varchar(32) DEFAULT NULL,\n" +
                        "  `health` int(10) DEFAULT NULL,\n" +
                        "  `character19` varchar(32) DEFAULT NULL,\n" +
                        "  `id0` int(10) DEFAULT NULL,\n" +
                        "  `deptno0` int(10) DEFAULT NULL,\n" +
                        "  `empno0` int(10) DEFAULT NULL,\n" +
                        "  `ename0` varchar(32) DEFAULT NULL,\n" +
                        "  `job0` varchar(32) DEFAULT NULL,\n" +
                        "  `sal0` float DEFAULT NULL,\n" +
                        "  `hiredate0` int(10) DEFAULT NULL,\n" +
                        "  `language0` varchar(32) DEFAULT NULL,\n" +
                        "  `health0` int(10) DEFAULT NULL,\n" +
                        "  `character0` varchar(32) DEFAULT NULL,\n" +
                        "  `id1` int(10) DEFAULT NULL,\n" +
                        "  `deptno1` int(10) DEFAULT NULL,\n" +
                        "  `empno1` int(10) DEFAULT NULL,\n" +
                        "  `ename1` varchar(32) DEFAULT NULL,\n" +
                        "  `job1` varchar(32) DEFAULT NULL,\n" +
                        "  `sal1` float DEFAULT NULL,\n" +
                        "  `hiredate1` int(10) DEFAULT NULL,\n" +
                        "  `language1` varchar(32) DEFAULT NULL,\n" +
                        "  `health1` int(10) DEFAULT NULL,\n" +
                        "  `character1` varchar(32) DEFAULT NULL,\n" +
                        "  `id2` int(10) DEFAULT NULL,\n" +
                        "  `deptno2` int(10) DEFAULT NULL,\n" +
                        "  `empno2` int(10) DEFAULT NULL,\n" +
                        "  `ename2` varchar(32) DEFAULT NULL,\n" +
                        "  `job2` varchar(32) DEFAULT NULL,\n" +
                        "  `sal2` float DEFAULT NULL,\n" +
                        "  `hiredate2` int(10) DEFAULT NULL,\n" +
                        "  `language2` varchar(32) DEFAULT NULL,\n" +
                        "  `health2` int(10) DEFAULT NULL,\n" +
                        "  `character2` varchar(32) DEFAULT NULL,\n" +
                        "  `id3` int(10) DEFAULT NULL,\n" +
                        "  `deptno3` int(10) DEFAULT NULL,\n" +
                        "  `empno3` int(10) DEFAULT NULL,\n" +
                        "  `ename3` varchar(32) DEFAULT NULL,\n" +
                        "  `job3` varchar(32) DEFAULT NULL,\n" +
                        "  `sal3` float DEFAULT NULL,\n" +
                        "  `hiredate3` int(10) DEFAULT NULL,\n" +
                        "  `language3` varchar(32) DEFAULT NULL,\n" +
                        "  `health3` int(10) DEFAULT NULL,\n" +
                        "  `character3` varchar(32) DEFAULT NULL\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8\n" +
                        "/*!50100 PARTITION BY RANGE (hiredate)\n" +
                        "(PARTITION p0 VALUES LESS THAN (20120101) ENGINE = InnoDB,\n" +
                        " PARTITION p1 VALUES LESS THAN (20150101) ENGINE = InnoDB,\n" +
                        " PARTITION p2 VALUES LESS THAN (20170101) ENGINE = InnoDB,\n" +
                        " PARTITION p3 VALUES LESS THAN MAXVALUE ENGINE = InnoDB) */";

                Statement statement = con.createStatement();
                statement.executeUpdate(sql_create);


            }

        } finally {
            con.close();
        }
    }

    public void insertMuchMysqlTable() throws SQLException {
        Connection connection = null;
        int count = 10000;
        for (int i = 50; i < 51; i++) {
            try {
                connection = getCon();
                connection.setAutoCommit(false);
                int num = 0;
                String sql50 = "insert into employee" + i + "(" +
                        "id,deptno,empno,ename,job,sal,hiredate,language19,health,character19," +
                        "id0,deptno0,empno0,ename0,job0,sal0,hiredate0,language0,health0,character0," +
                        "id1,deptno1,empno1,ename1,job1,sal1,hiredate1,language1,health1,character1," +
                        "id2,deptno2,empno2,ename2,job2,sal2,hiredate2,language2,health2,character2," +
                        "id3,deptno3,empno3,ename3,job3,sal3,hiredate3,language3,health3,character3) " +
                        "values (" +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql50);
                for (int j = 0; j < count; j++) {
                    int arg_id = (int) (100000 + Math.random() * 1000000000);
                    int arg_deptNo = (int) (100 + Math.random() * 100000);
                    int arg_empNo = (int) (10000 + Math.random() * 2000000000);
                    String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
                    String arg_job = "job_" + getRamdomDataASC(3);
                    Float arg_sal = (float) (1000 + Math.random() * 1000000000);
                    int arg_hireDate = (int) (20160101 + Math.random() * 1130);
                    String arg_language = "language_" + getRamdomDataASC(5);
                    int arg_health = (int) (Math.random() * 2);
                    String arg_character = "character_" + getRamdomDataASC(7);

                    statement.setString(1, UUID.randomUUID().toString());
                    statement.setInt(2, arg_deptNo);
                    statement.setInt(3, arg_empNo);
                    statement.setString(4, arg_eName);
                    statement.setString(5, arg_job);
                    statement.setFloat(6, arg_sal);
                    statement.setInt(7, arg_hireDate);
                    statement.setString(8, arg_language);
                    statement.setInt(9, arg_health);
                    statement.setString(10, arg_character);

                    statement.setInt(11, arg_id);
                    statement.setInt(12, arg_deptNo);
                    statement.setInt(13, arg_empNo);
                    statement.setString(14, arg_eName);
                    statement.setString(15, arg_job);
                    statement.setFloat(16, arg_sal);
                    statement.setInt(17, arg_hireDate);
                    statement.setString(18, arg_language);
                    statement.setInt(19, arg_health);
                    statement.setString(20, arg_character);

                    statement.setInt(21, arg_id);
                    statement.setInt(22, arg_deptNo);
                    statement.setInt(23, arg_empNo);
                    statement.setString(24, arg_eName);
                    statement.setString(25, arg_job);
                    statement.setFloat(26, arg_sal);
                    statement.setInt(27, arg_hireDate);
                    statement.setString(28, arg_language);
                    statement.setInt(29, arg_health);
                    statement.setString(30, arg_character);

                    statement.setInt(31, arg_id);
                    statement.setInt(32, arg_deptNo);
                    statement.setInt(33, arg_empNo);
                    statement.setString(34, arg_eName);
                    statement.setString(35, arg_job);
                    statement.setFloat(36, arg_sal);
                    statement.setInt(37, arg_hireDate);
                    statement.setString(38, arg_language);
                    statement.setInt(39, arg_health);
                    statement.setString(40, arg_character);

                    statement.setInt(41, arg_id);
                    statement.setInt(42, arg_deptNo);
                    statement.setInt(43, arg_empNo);
                    statement.setString(44, arg_eName);
                    statement.setString(45, arg_job);
                    statement.setFloat(46, arg_sal);
                    statement.setInt(47, arg_hireDate);
                    statement.setString(48, arg_language);
                    statement.setInt(49, arg_health);
                    statement.setString(50, arg_character);
                    statement.addBatch();
                    num++;
                    if (num != 0 && num % 200 == 0) {
                        statement.executeBatch();
                        connection.commit();
                        statement.clearBatch();
                        num = 0;
                    }
                    statement.executeBatch();
                    connection.commit();
                }

            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        }


    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void insertMysql() throws SQLException {
        Connection con = null;
        int count = 200;
        try {
            con = getCon();
            con.setAutoCommit(false);
            String sql200 = "insert into employee1(id,deptno,empno,ename,job,sal,hiredate,language19,health,character19,id0,deptno0,empno0,ename0,job0,sal0,hiredate0,language0,health0,character0,id1,deptno1,empno1,ename1,job1,sal1,hiredate1,language1,health1,character1,id2,deptno2,empno2,ename2,job2,sal2,hiredate2,language2,health2,character2,id3,deptno3,empno3,ename3,job3,sal3,hiredate3,language3,health3,character3,id4,deptno4,empno4,ename4,job4,sal4,hiredate4,language4,health4,character4,id5,deptno5,empno5,ename5,job5,sal5,hiredate5,language5,health5,character5,id6,deptno6,empno6,ename6,job6,sal6,hiredate6,language6,health6,character6,id7,deptno7,empno7,ename7,job7,sal7,hiredate7,language7,health7,character7,id8,deptno8,empno8,ename8,job8,sal8,hiredate8,language8,health8,character8,id9,deptno9,empno9,ename9,job9,sal9,hiredate9,language9,health9,character9,id10,deptno10,empno10,ename10,job10,sal10,hiredate10,language10,health10,character10,id11,deptno11,empno11,ename11,job11,sal11,hiredate11,language11,health11,character11,id12,deptno12,empno12,ename12,job12,sal12,hiredate12,language12,health12,character12,id13,deptno13,empno13,ename13,job13,sal13,hiredate13,language13,health13,character13,id14,deptno14,empno14,ename14,job14,sal14,hiredate14,language14,health14,character14,id15,deptno15,empno15,ename15,job15,sal15,hiredate15,language15,health15,character15,id16,deptno16,empno16,ename16,job16,sal16,hiredate16,language16,health16,character16,id17,deptno17,empno17,ename17,job17,sal17,hiredate17,language17,health17,character17,id18,deptno18,empno18,ename18,job18,sal18,hiredate18,language18,health18,character18) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql50 = "insert into employee50(" +
                    "id,deptno,empno,ename,job,sal,hiredate,language19,health,character19" +
                    ",id0,deptno0,empno0,ename0,job0,sal0,hiredate0,language0,health0,character0" +
                    ",id1,deptno1,empno1,ename1,job1,sal1,hiredate1,language1,health1,character1" +
                    ",id2,deptno2,empno2,ename2,job2,sal2,hiredate2,language2,health2,character2" +
                    ",id3,deptno3,empno3,ename3,job3,sal3,hiredate3,language3,health3,character3" +
//                    ",id4,deptno4,empno4,ename4,job4,sal4,hiredate4,language4,health4,character4" +
                    ") " +
                    "values " +
                    "(?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?)";
            String sql_list0 = "insert into list0(x,y,s,province) values (?,?,?,?)";
            String sql_list = "insert into list(x,y,s) values (?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql_list0);
            long num = 0;
            for (int i = 0; i < count; i++) {
                System.out.println("第" + i + "次");
                int arg_id = (int) (100000 + Math.random() * 1000000000);
                int arg_deptNo = (int) (100 + Math.random() * 100000);
                int arg_empNo = (int) (10000 + Math.random() * 2000000000);
                String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
                String arg_job = "job_" + getRamdomDataASC(3);
                Float arg_sal = (float) (1000 + Math.random() * 1000000000);
                int arg_hireDate = (int) (20160101 + Math.random() * 1130);
                String arg_language = "language_" + getRamdomDataASC(5);
                int arg_health = (int) (Math.random() * 2);
                String arg_character = "character_" + getRamdomDataASC(7);
//
                statement.setString(1, arg_eName);
                statement.setFloat(2, arg_sal);
                statement.setInt(3, arg_id);
                statement.setString(4, arg_language);
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setInt(2, arg_deptNo);
//                statement.setInt(3, arg_empNo);
//                statement.setString(4, arg_eName);
//                statement.setString(5, arg_job);
//                statement.setFloat(6, arg_sal);
//                statement.setInt(7, arg_hireDate);
//                statement.setString(8, arg_language);
//                statement.setInt(9, arg_health);
//                statement.setString(10, arg_character);
//
//                statement.setInt(11, arg_id);
//                statement.setInt(12, arg_deptNo);
//                statement.setInt(13, arg_empNo);
//                statement.setString(14, arg_eName);
//                statement.setString(15, arg_job);
//                statement.setFloat(16, arg_sal);
//                statement.setInt(17, arg_hireDate);
//                statement.setString(18, arg_language);
//                statement.setInt(19, arg_health);
//                statement.setString(20, arg_character);
//
//                statement.setInt(21, arg_id);
//                statement.setInt(22, arg_deptNo);
//                statement.setInt(23, arg_empNo);
//                statement.setString(24, arg_eName);
//                statement.setString(25, arg_job);
//                statement.setFloat(26, arg_sal);
//                statement.setInt(27, arg_hireDate);
//                statement.setString(28, arg_language);
//                statement.setInt(29, arg_health);
//                statement.setString(30, arg_character);
//
//                statement.setInt(31, arg_id);
//                statement.setInt(32, arg_deptNo);
//                statement.setInt(33, arg_empNo);
//                statement.setString(34, arg_eName);
//                statement.setString(35, arg_job);
//                statement.setFloat(36, arg_sal);
//                statement.setInt(37, arg_hireDate);
//                statement.setString(38, arg_language);
//                statement.setInt(39, arg_health);
//                statement.setString(40, arg_character);
//
//                statement.setInt(41, arg_id);
//                statement.setInt(42, arg_deptNo);
//                statement.setInt(43, arg_empNo);
//                statement.setString(44, arg_eName);
//                statement.setString(45, arg_job);
//                statement.setFloat(46, arg_sal);
//                statement.setInt(47, arg_hireDate);
//                statement.setString(48, arg_language);
//                statement.setInt(49, arg_health);
//                statement.setString(50, arg_character);

//                statement.setInt(51, arg_id);
//                statement.setInt(52, arg_deptNo);
//                statement.setInt(53, arg_empNo);
//                statement.setString(54, arg_eName);
//                statement.setString(55, arg_job);
//                statement.setFloat(56, arg_sal);
//                statement.setInt(57, arg_hireDate);
//                statement.setString(58, arg_language);
//                statement.setInt(59, arg_health);
//                statement.setString(60, arg_character);
//
//                statement.setInt(61, arg_id);
//                statement.setInt(62, arg_deptNo);
//                statement.setInt(63, arg_empNo);
//                statement.setString(64, arg_eName);
//                statement.setString(65, arg_job);
//                statement.setFloat(66, arg_sal);
//                statement.setInt(67, arg_hireDate);
//                statement.setString(68, arg_language);
//                statement.setInt(69, arg_health);
//                statement.setString(70, arg_character);
//
//                statement.setInt(71, arg_id);
//                statement.setInt(72, arg_deptNo);
//                statement.setInt(73, arg_empNo);
//                statement.setString(74, arg_eName);
//                statement.setString(75, arg_job);
//                statement.setFloat(76, arg_sal);
//                statement.setInt(77, arg_hireDate);
//                statement.setString(78, arg_language);
//                statement.setInt(79, arg_health);
//                statement.setString(80, arg_character);
//
//                statement.setInt(81, arg_id);
//                statement.setInt(82, arg_deptNo);
//                statement.setInt(83, arg_empNo);
//                statement.setString(84, arg_eName);
//                statement.setString(85, arg_job);
//                statement.setFloat(86, arg_sal);
//                statement.setInt(87, arg_hireDate);
//                statement.setString(88, arg_language);
//                statement.setInt(89, arg_health);
//                statement.setString(90, arg_character);
//
//                statement.setInt(91, arg_id);
//                statement.setInt(92, arg_deptNo);
//                statement.setInt(93, arg_empNo);
//                statement.setString(94, arg_eName);
//                statement.setString(95, arg_job);
//                statement.setFloat(96, arg_sal);
//                statement.setInt(97, arg_hireDate);
//                statement.setString(98, arg_language);
//                statement.setInt(99, arg_health);
//                statement.setString(100, arg_character);
//
//
//                statement.setInt(101, arg_id);
//                statement.setInt(102, arg_deptNo);
//                statement.setInt(103, arg_empNo);
//                statement.setString(104, arg_eName);
//                statement.setString(105, arg_job);
//                statement.setFloat(106, arg_sal);
//                statement.setInt(107, arg_hireDate);
//                statement.setString(108, arg_language);
//                statement.setInt(109, arg_health);
//                statement.setString(110, arg_character);
//
//
//                statement.setInt(111, arg_id);
//                statement.setInt(112, arg_deptNo);
//                statement.setInt(113, arg_empNo);
//                statement.setString(114, arg_eName);
//                statement.setString(115, arg_job);
//                statement.setFloat(116, arg_sal);
//                statement.setInt(117, arg_hireDate);
//                statement.setString(118, arg_language);
//                statement.setInt(119, arg_health);
//                statement.setString(120, arg_character);
//
//                statement.setInt(121, arg_id);
//                statement.setInt(122, arg_deptNo);
//                statement.setInt(123, arg_empNo);
//                statement.setString(124, arg_eName);
//                statement.setString(125, arg_job);
//                statement.setFloat(126, arg_sal);
//                statement.setInt(127, arg_hireDate);
//                statement.setString(128, arg_language);
//                statement.setInt(129, arg_health);
//                statement.setString(130, arg_character);
//
//                statement.setInt(131, arg_id);
//                statement.setInt(132, arg_deptNo);
//                statement.setInt(133, arg_empNo);
//                statement.setString(134, arg_eName);
//                statement.setString(135, arg_job);
//                statement.setFloat(136, arg_sal);
//                statement.setInt(137, arg_hireDate);
//                statement.setString(138, arg_language);
//                statement.setInt(139, arg_health);
//                statement.setString(140, arg_character);
//
//                statement.setInt(141, arg_id);
//                statement.setInt(142, arg_deptNo);
//                statement.setInt(143, arg_empNo);
//                statement.setString(144, arg_eName);
//                statement.setString(145, arg_job);
//                statement.setFloat(146, arg_sal);
//                statement.setInt(147, arg_hireDate);
//                statement.setString(148, arg_language);
//                statement.setInt(149, arg_health);
//                statement.setString(150, arg_character);
//
//                statement.setInt(151, arg_id);
//                statement.setInt(152, arg_deptNo);
//                statement.setInt(153, arg_empNo);
//                statement.setString(154, arg_eName);
//                statement.setString(155, arg_job);
//                statement.setFloat(156, arg_sal);
//                statement.setInt(157, arg_hireDate);
//                statement.setString(158, arg_language);
//                statement.setInt(159, arg_health);
//                statement.setString(160, arg_character);
//
//                statement.setInt(161, arg_id);
//                statement.setInt(162, arg_deptNo);
//                statement.setInt(163, arg_empNo);
//                statement.setString(164, arg_eName);
//                statement.setString(165, arg_job);
//                statement.setFloat(166, arg_sal);
//                statement.setInt(167, arg_hireDate);
//                statement.setString(168, arg_language);
//                statement.setInt(169, arg_health);
//                statement.setString(170, arg_character);
//
//                statement.setInt(171, arg_id);
//                statement.setInt(172, arg_deptNo);
//                statement.setInt(173, arg_empNo);
//                statement.setString(174, arg_eName);
//                statement.setString(175, arg_job);
//                statement.setFloat(176, arg_sal);
//                statement.setInt(177, arg_hireDate);
//                statement.setString(178, arg_language);
//                statement.setInt(179, arg_health);
//                statement.setString(180, arg_character);
//
//                statement.setInt(181, arg_id);
//                statement.setInt(182, arg_deptNo);
//                statement.setInt(183, arg_empNo);
//                statement.setString(184, arg_eName);
//                statement.setString(185, arg_job);
//                statement.setFloat(186, arg_sal);
//                statement.setInt(187, arg_hireDate);
//                statement.setString(188, arg_language);
//                statement.setInt(189, arg_health);
//                statement.setString(190, arg_character);
//
//                statement.setInt(191, arg_id);
//                statement.setInt(192, arg_deptNo);
//                statement.setInt(193, arg_empNo);
//                statement.setString(194, arg_eName);
//                statement.setString(195, arg_job);
//                statement.setFloat(196, arg_sal);
//                statement.setInt(197, arg_hireDate);
//                statement.setString(198, arg_language);
//                statement.setInt(199, arg_health);
//                statement.setString(200, arg_character);


                statement.addBatch();
                num++;
                if (num != 0 && num % 300 == 0) {
                    statement.executeBatch();
                    con.commit();
                    statement.clearBatch();
                    num = 0;
                }
            }
            statement.executeBatch();
            con.commit();

        } catch (
                Exception e)

        {
            e.printStackTrace();
            con.rollback();
        } finally

        {
            if (con != null) {
                con.close();
            }
        }

    }

    public void insertSqlServer() throws SQLException {
        Connection con = null;
        int count = 100;
        try {
            con = getCon();
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement("insert into Employee2(id,deptno,empno,ename,job,sal,hiredate,language19,health,character19,id0,deptno0,empno0,ename0,job0,sal0,hiredate0,language0,health0,character0,id1,deptno1,empno1,ename1,job1,sal1,hiredate1,language1,health1,character1,id2,deptno2,empno2,ename2,job2,sal2,hiredate2,language2,health2,character2,id3,deptno3,empno3,ename3,job3,sal3,hiredate3,language3,health3,character3,id4,deptno4,empno4,ename4,job4,sal4,hiredate4,language4,health4,character4,id5,deptno5,empno5,ename5,job5,sal5,hiredate5,language5,health5,character5,id6,deptno6,empno6,ename6,job6,sal6,hiredate6,language6,health6,character6,id7,deptno7,empno7,ename7,job7,sal7,hiredate7,language7,health7,character7,id8,deptno8,empno8,ename8,job8,sal8,hiredate8,language8,health8,character8,id9,deptno9,empno9,ename9,job9,sal9,hiredate9,language9,health9,character9,id10,deptno10,empno10,ename10,job10,sal10,hiredate10,language10,health10,character10,id11,deptno11,empno11,ename11,job11,sal11,hiredate11,language11,health11,character11,id12,deptno12,empno12,ename12,job12,sal12,hiredate12,language12,health12,character12,id13,deptno13,empno13,ename13,job13,sal13,hiredate13,language13,health13,character13,id14,deptno14,empno14,ename14,job14,sal14,hiredate14,language14,health14,character14,id15,deptno15,empno15,ename15,job15,sal15,hiredate15,language15,health15,character15,id16,deptno16,empno16,ename16,job16,sal16,hiredate16,language16,health16,character16,id17,deptno17,empno17,ename17,job17,sal17,hiredate17,language17,health17,character17,id18,deptno18,empno18,ename18,job18,sal18,hiredate18,language18,health18,character18) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            long num = 0;
            for (int i = 0; i < count; i++) {
                int arg_id = (int) (100000 + Math.random() * 1000000);
                int arg_deptNo = (int) (100 + Math.random() * 10000);
                int arg_empNo = (int) (10000 + Math.random() * 2000000);
                String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
                String arg_job = "job_" + getRamdomDataASC(3);
                Float arg_sal = (float) (1000 + Math.random() * 100000);
                int arg_hireDate = (int) (20110101 + Math.random() * 59999);
                String arg_language = "language_" + getRamdomDataASC(5);
                int arg_health = (int) (Math.random() * 2);
                String arg_character = "character_" + getRamdomDataASC(7);

                statement.setString(1, UUID.randomUUID().toString());
                statement.setInt(2, arg_deptNo);
                statement.setInt(3, arg_empNo);
                statement.setString(4, arg_eName);
                statement.setString(5, arg_job);
                statement.setFloat(6, arg_sal);
                statement.setInt(7, arg_hireDate);
                statement.setString(8, arg_language);
                statement.setInt(9, arg_health);
                statement.setString(10, arg_character);

                statement.setInt(11, arg_id);
                statement.setInt(12, arg_deptNo);
                statement.setInt(13, arg_empNo);
                statement.setString(14, arg_eName);
                statement.setString(15, arg_job);
                statement.setFloat(16, arg_sal);
                statement.setInt(17, arg_hireDate);
                statement.setString(18, arg_language);
                statement.setInt(19, arg_health);
                statement.setString(20, arg_character);

                statement.setInt(21, arg_id);
                statement.setInt(22, arg_deptNo);
                statement.setInt(23, arg_empNo);
                statement.setString(24, arg_eName);
                statement.setString(25, arg_job);
                statement.setFloat(26, arg_sal);
                statement.setInt(27, arg_hireDate);
                statement.setString(28, arg_language);
                statement.setInt(29, arg_health);
                statement.setString(30, arg_character);

                statement.setInt(31, arg_id);
                statement.setInt(32, arg_deptNo);
                statement.setInt(33, arg_empNo);
                statement.setString(34, arg_eName);
                statement.setString(35, arg_job);
                statement.setFloat(36, arg_sal);
                statement.setInt(37, arg_hireDate);
                statement.setString(38, arg_language);
                statement.setInt(39, arg_health);
                statement.setString(40, arg_character);

                statement.setInt(41, arg_id);
                statement.setInt(42, arg_deptNo);
                statement.setInt(43, arg_empNo);
                statement.setString(44, arg_eName);
                statement.setString(45, arg_job);
                statement.setFloat(46, arg_sal);
                statement.setInt(47, arg_hireDate);
                statement.setString(48, arg_language);
                statement.setInt(49, arg_health);
                statement.setString(50, arg_character);

                statement.setInt(51, arg_id);
                statement.setInt(52, arg_deptNo);
                statement.setInt(53, arg_empNo);
                statement.setString(54, arg_eName);
                statement.setString(55, arg_job);
                statement.setFloat(56, arg_sal);
                statement.setInt(57, arg_hireDate);
                statement.setString(58, arg_language);
                statement.setInt(59, arg_health);
                statement.setString(60, arg_character);

                statement.setInt(61, arg_id);
                statement.setInt(62, arg_deptNo);
                statement.setInt(63, arg_empNo);
                statement.setString(64, arg_eName);
                statement.setString(65, arg_job);
                statement.setFloat(66, arg_sal);
                statement.setInt(67, arg_hireDate);
                statement.setString(68, arg_language);
                statement.setInt(69, arg_health);
                statement.setString(70, arg_character);

                statement.setInt(71, arg_id);
                statement.setInt(72, arg_deptNo);
                statement.setInt(73, arg_empNo);
                statement.setString(74, arg_eName);
                statement.setString(75, arg_job);
                statement.setFloat(76, arg_sal);
                statement.setInt(77, arg_hireDate);
                statement.setString(78, arg_language);
                statement.setInt(79, arg_health);
                statement.setString(80, arg_character);

                statement.setInt(81, arg_id);
                statement.setInt(82, arg_deptNo);
                statement.setInt(83, arg_empNo);
                statement.setString(84, arg_eName);
                statement.setString(85, arg_job);
                statement.setFloat(86, arg_sal);
                statement.setInt(87, arg_hireDate);
                statement.setString(88, arg_language);
                statement.setInt(89, arg_health);
                statement.setString(90, arg_character);

                statement.setInt(91, arg_id);
                statement.setInt(92, arg_deptNo);
                statement.setInt(93, arg_empNo);
                statement.setString(94, arg_eName);
                statement.setString(95, arg_job);
                statement.setFloat(96, arg_sal);
                statement.setInt(97, arg_hireDate);
                statement.setString(98, arg_language);
                statement.setInt(99, arg_health);
                statement.setString(100, arg_character);


                statement.setInt(101, arg_id);
                statement.setInt(102, arg_deptNo);
                statement.setInt(103, arg_empNo);
                statement.setString(104, arg_eName);
                statement.setString(105, arg_job);
                statement.setFloat(106, arg_sal);
                statement.setInt(107, arg_hireDate);
                statement.setString(108, arg_language);
                statement.setInt(109, arg_health);
                statement.setString(110, arg_character);


                statement.setInt(111, arg_id);
                statement.setInt(112, arg_deptNo);
                statement.setInt(113, arg_empNo);
                statement.setString(114, arg_eName);
                statement.setString(115, arg_job);
                statement.setFloat(116, arg_sal);
                statement.setInt(117, arg_hireDate);
                statement.setString(118, arg_language);
                statement.setInt(119, arg_health);
                statement.setString(120, arg_character);

                statement.setInt(121, arg_id);
                statement.setInt(122, arg_deptNo);
                statement.setInt(123, arg_empNo);
                statement.setString(124, arg_eName);
                statement.setString(125, arg_job);
                statement.setFloat(126, arg_sal);
                statement.setInt(127, arg_hireDate);
                statement.setString(128, arg_language);
                statement.setInt(129, arg_health);
                statement.setString(130, arg_character);

                statement.setInt(131, arg_id);
                statement.setInt(132, arg_deptNo);
                statement.setInt(133, arg_empNo);
                statement.setString(134, arg_eName);
                statement.setString(135, arg_job);
                statement.setFloat(136, arg_sal);
                statement.setInt(137, arg_hireDate);
                statement.setString(138, arg_language);
                statement.setInt(139, arg_health);
                statement.setString(140, arg_character);

                statement.setInt(141, arg_id);
                statement.setInt(142, arg_deptNo);
                statement.setInt(143, arg_empNo);
                statement.setString(144, arg_eName);
                statement.setString(145, arg_job);
                statement.setFloat(146, arg_sal);
                statement.setInt(147, arg_hireDate);
                statement.setString(148, arg_language);
                statement.setInt(149, arg_health);
                statement.setString(150, arg_character);

                statement.setInt(151, arg_id);
                statement.setInt(152, arg_deptNo);
                statement.setInt(153, arg_empNo);
                statement.setString(154, arg_eName);
                statement.setString(155, arg_job);
                statement.setFloat(156, arg_sal);
                statement.setInt(157, arg_hireDate);
                statement.setString(158, arg_language);
                statement.setInt(159, arg_health);
                statement.setString(160, arg_character);

                statement.setInt(161, arg_id);
                statement.setInt(162, arg_deptNo);
                statement.setInt(163, arg_empNo);
                statement.setString(164, arg_eName);
                statement.setString(165, arg_job);
                statement.setFloat(166, arg_sal);
                statement.setInt(167, arg_hireDate);
                statement.setString(168, arg_language);
                statement.setInt(169, arg_health);
                statement.setString(170, arg_character);

                statement.setInt(171, arg_id);
                statement.setInt(172, arg_deptNo);
                statement.setInt(173, arg_empNo);
                statement.setString(174, arg_eName);
                statement.setString(175, arg_job);
                statement.setFloat(176, arg_sal);
                statement.setInt(177, arg_hireDate);
                statement.setString(178, arg_language);
                statement.setInt(179, arg_health);
                statement.setString(180, arg_character);

                statement.setInt(181, arg_id);
                statement.setInt(182, arg_deptNo);
                statement.setInt(183, arg_empNo);
                statement.setString(184, arg_eName);
                statement.setString(185, arg_job);
                statement.setFloat(186, arg_sal);
                statement.setInt(187, arg_hireDate);
                statement.setString(188, arg_language);
                statement.setInt(189, arg_health);
                statement.setString(190, arg_character);

                statement.setInt(191, arg_id);
                statement.setInt(192, arg_deptNo);
                statement.setInt(193, arg_empNo);
                statement.setString(194, arg_eName);
                statement.setString(195, arg_job);
                statement.setFloat(196, arg_sal);
                statement.setInt(197, arg_hireDate);
                statement.setString(198, arg_language);
                statement.setInt(199, arg_health);
                statement.setString(200, arg_character);

                statement.addBatch();
                num++;
                if (num != 0 && num % 1 == 0) {
                    statement.executeBatch();
                    con.commit();
                    statement.clearBatch();
                    num = 0;
                }
            }
            statement.executeBatch();
            con.commit();

        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public void insertPostgreSql() throws SQLException {
        Connection con = null;
        int count = 1503917;
        try {
            con = getCon();
            con.setAutoCommit(false);
            SimpleDateFormat date_formate = new SimpleDateFormat("yyyy-MM-dd");
            String sql_pg_list="insert into pg_list(x,y,s,id) values(?,?,?,?)";
            String sql_employee="insert into employee(" +
                    "id,deptno,empno,ename,job,sal,hiredate,language19,health,character19," +
                    "id0,deptno0,empno0,ename0,job0,sal0,hiredate0,language0,health0,character0," +
                    "id1,deptno1,empno1,ename1,job1,sal1,hiredate1,language1,health1,character1," +
                    "id2,deptno2,empno2,ename2,job2,sal2,hiredate2,language2,health2,character2," +
                    "id3,deptno3,empno3,ename3,job3,sal3,hiredate3,language3,health3,character3," +
                    "id4,deptno4,empno4,ename4,job4,sal4,hiredate4,language4,health4,character4," +
                    "id5,deptno5,empno5,ename5,job5,sal5,hiredate5,language5,health5,character5," +
                    "id6,deptno6,empno6,ename6,job6,sal6,hiredate6,language6,health6,character6," +
                    "id7,deptno7,empno7,ename7,job7,sal7,hiredate7,language7,health7,character7," +
                    "id8,deptno8,empno8,ename8,job8,sal8,hiredate8,language8,health8,character8," +
                    "id9,deptno9,empno9,ename9,job9,sal9,hiredate9,language9,health9,character9," +
                    "id10,deptno10,empno10,ename10,job10,sal10,hiredate10,language10,health10,character10," +
                    "id11,deptno11,empno11,ename11,job11,sal11,hiredate11,language11,health11,character11," +
                    "id12,deptno12,empno12,ename12,job12,sal12,hiredate12,language12,health12,character12," +
                    "id13,deptno13,empno13,ename13,job13,sal13,hiredate13,language13,health13,character13," +
                    "id14,deptno14,empno14,ename14,job14,sal14,hiredate14,language14,health14,character14," +
                    "id15,deptno15,empno15,ename15,job15,sal15,hiredate15,language15,health15,character15," +
                    "id16,deptno16,empno16,ename16,job16,sal16,hiredate16,language16,health16,character16," +
                    "id17,deptno17,empno17,ename17,job17,sal17,hiredate17,language17,health17,character17," +
                    "id18,deptno18,empno18,ename18,job18,sal18,hiredate18,language18,health18,character18," +
                    "start_time,end_time)" +
                    " values (" +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql_pg_list);
            long num = 0;
            for (int i = 0; i < count; i++) {
                int arg_id = (int) (100000 + Math.random() * 1000000000);
                int arg_deptNo = (int) (100 + Math.random() * 100000);
                int arg_empNo = (int) (10000 + Math.random() * 2000000000);
                String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
                String arg_job = "job_" + getRamdomDataASC(3);
                Float arg_sal = (float) (1000 + Math.random() * 1000000000);
                int arg_hireDate = (int) (20120101 + Math.random() * 69999);
                String arg_language = "language_" + getRamdomDataASC(5);
                int arg_health = (int) (Math.random() * 2);
                String arg_character = "character_" + getRamdomDataASC(7);
                String create_time = "2018-" + (int) (1 + Math.random() * 11) + "-" + (int) (1 + Math.random() * 20) + " 00:00:00";
                Date create_time0 = new Date(date_formate.parse(create_time).getTime());
                Timestamp create_time1 = new Timestamp(create_time0.getTime());

                statement.setString(1, arg_eName);
                statement.setFloat(2, arg_sal);
                statement.setInt(3, arg_empNo);
                statement.setInt(4, i);
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setInt(2, arg_deptNo);
//                statement.setInt(3, arg_empNo);
//                statement.setString(4, arg_eName);
//                statement.setString(5, arg_job);
//                statement.setFloat(6, arg_sal);
//                statement.setInt(7, arg_hireDate);
//                statement.setString(8, arg_language);
//                statement.setInt(9, arg_health);
//                statement.setString(10, arg_character);

//                statement.setInt(11, arg_id);
//                statement.setInt(12, arg_deptNo);
//                statement.setInt(13, arg_empNo);
//                statement.setString(14, arg_eName);
//                statement.setString(15, arg_job);
//                statement.setFloat(16, arg_sal);
//                statement.setInt(17, arg_hireDate);
//                statement.setString(18, arg_language);
//                statement.setInt(19, arg_health);
//                statement.setString(20, arg_character);
//
//                statement.setInt(21, arg_id);
//                statement.setInt(22, arg_deptNo);
//                statement.setInt(23, arg_empNo);
//                statement.setString(24, arg_eName);
//                statement.setString(25, arg_job);
//                statement.setFloat(26, arg_sal);
//                statement.setInt(27, arg_hireDate);
//                statement.setString(28, arg_language);
//                statement.setInt(29, arg_health);
//                statement.setString(30, arg_character);
//
//                statement.setInt(31, arg_id);
//                statement.setInt(32, arg_deptNo);
//                statement.setInt(33, arg_empNo);
//                statement.setString(34, arg_eName);
//                statement.setString(35, arg_job);
//                statement.setFloat(36, arg_sal);
//                statement.setInt(37, arg_hireDate);
//                statement.setString(38, arg_language);
//                statement.setInt(39, arg_health);
//                statement.setString(40, arg_character);
//
//                statement.setInt(41, arg_id);
//                statement.setInt(42, arg_deptNo);
//                statement.setInt(43, arg_empNo);
//                statement.setString(44, arg_eName);
//                statement.setString(45, arg_job);
//                statement.setFloat(46, arg_sal);
//                statement.setInt(47, arg_hireDate);
//                statement.setString(48, arg_language);
//                statement.setInt(49, arg_health);
//                statement.setString(50, arg_character);
//
//                statement.setInt(51, arg_id);
//                statement.setInt(52, arg_deptNo);
//                statement.setInt(53, arg_empNo);
//                statement.setString(54, arg_eName);
//                statement.setString(55, arg_job);
//                statement.setFloat(56, arg_sal);
//                statement.setInt(57, arg_hireDate);
//                statement.setString(58, arg_language);
//                statement.setInt(59, arg_health);
//                statement.setString(60, arg_character);
//
//                statement.setInt(61, arg_id);
//                statement.setInt(62, arg_deptNo);
//                statement.setInt(63, arg_empNo);
//                statement.setString(64, arg_eName);
//                statement.setString(65, arg_job);
//                statement.setFloat(66, arg_sal);
//                statement.setInt(67, arg_hireDate);
//                statement.setString(68, arg_language);
//                statement.setInt(69, arg_health);
//                statement.setString(70, arg_character);
//
//                statement.setInt(71, arg_id);
//                statement.setInt(72, arg_deptNo);
//                statement.setInt(73, arg_empNo);
//                statement.setString(74, arg_eName);
//                statement.setString(75, arg_job);
//                statement.setFloat(76, arg_sal);
//                statement.setInt(77, arg_hireDate);
//                statement.setString(78, arg_language);
//                statement.setInt(79, arg_health);
//                statement.setString(80, arg_character);
//
//                statement.setInt(81, arg_id);
//                statement.setInt(82, arg_deptNo);
//                statement.setInt(83, arg_empNo);
//                statement.setString(84, arg_eName);
//                statement.setString(85, arg_job);
//                statement.setFloat(86, arg_sal);
//                statement.setInt(87, arg_hireDate);
//                statement.setString(88, arg_language);
//                statement.setInt(89, arg_health);
//                statement.setString(90, arg_character);
//
//                statement.setInt(91, arg_id);
//                statement.setInt(92, arg_deptNo);
//                statement.setInt(93, arg_empNo);
//                statement.setString(94, arg_eName);
//                statement.setString(95, arg_job);
//                statement.setFloat(96, arg_sal);
//                statement.setInt(97, arg_hireDate);
//                statement.setString(98, arg_language);
//                statement.setInt(99, arg_health);
//                statement.setString(100, arg_character);
//
//
//                statement.setInt(101, arg_id);
//                statement.setInt(102, arg_deptNo);
//                statement.setInt(103, arg_empNo);
//                statement.setString(104, arg_eName);
//                statement.setString(105, arg_job);
//                statement.setFloat(106, arg_sal);
//                statement.setInt(107, arg_hireDate);
//                statement.setString(108, arg_language);
//                statement.setInt(109, arg_health);
//                statement.setString(110, arg_character);
//
//
//                statement.setInt(111, arg_id);
//                statement.setInt(112, arg_deptNo);
//                statement.setInt(113, arg_empNo);
//                statement.setString(114, arg_eName);
//                statement.setString(115, arg_job);
//                statement.setFloat(116, arg_sal);
//                statement.setInt(117, arg_hireDate);
//                statement.setString(118, arg_language);
//                statement.setInt(119, arg_health);
//                statement.setString(120, arg_character);
//
//                statement.setInt(121, arg_id);
//                statement.setInt(122, arg_deptNo);
//                statement.setInt(123, arg_empNo);
//                statement.setString(124, arg_eName);
//                statement.setString(125, arg_job);
//                statement.setFloat(126, arg_sal);
//                statement.setInt(127, arg_hireDate);
//                statement.setString(128, arg_language);
//                statement.setInt(129, arg_health);
//                statement.setString(130, arg_character);
//
//                statement.setInt(131, arg_id);
//                statement.setInt(132, arg_deptNo);
//                statement.setInt(133, arg_empNo);
//                statement.setString(134, arg_eName);
//                statement.setString(135, arg_job);
//                statement.setFloat(136, arg_sal);
//                statement.setInt(137, arg_hireDate);
//                statement.setString(138, arg_language);
//                statement.setInt(139, arg_health);
//                statement.setString(140, arg_character);
//
//                statement.setInt(141, arg_id);
//                statement.setInt(142, arg_deptNo);
//                statement.setInt(143, arg_empNo);
//                statement.setString(144, arg_eName);
//                statement.setString(145, arg_job);
//                statement.setFloat(146, arg_sal);
//                statement.setInt(147, arg_hireDate);
//                statement.setString(148, arg_language);
//                statement.setInt(149, arg_health);
//                statement.setString(150, arg_character);
//
//                statement.setInt(151, arg_id);
//                statement.setInt(152, arg_deptNo);
//                statement.setInt(153, arg_empNo);
//                statement.setString(154, arg_eName);
//                statement.setString(155, arg_job);
//                statement.setFloat(156, arg_sal);
//                statement.setInt(157, arg_hireDate);
//                statement.setString(158, arg_language);
//                statement.setInt(159, arg_health);
//                statement.setString(160, arg_character);
//
//                statement.setInt(161, arg_id);
//                statement.setInt(162, arg_deptNo);
//                statement.setInt(163, arg_empNo);
//                statement.setString(164, arg_eName);
//                statement.setString(165, arg_job);
//                statement.setFloat(166, arg_sal);
//                statement.setInt(167, arg_hireDate);
//                statement.setString(168, arg_language);
//                statement.setInt(169, arg_health);
//                statement.setString(170, arg_character);
//
//                statement.setInt(171, arg_id);
//                statement.setInt(172, arg_deptNo);
//                statement.setInt(173, arg_empNo);
//                statement.setString(174, arg_eName);
//                statement.setString(175, arg_job);
//                statement.setFloat(176, arg_sal);
//                statement.setInt(177, arg_hireDate);
//                statement.setString(178, arg_language);
//                statement.setInt(179, arg_health);
//                statement.setString(180, arg_character);
//
//                statement.setInt(181, arg_id);
//                statement.setInt(182, arg_deptNo);
//                statement.setInt(183, arg_empNo);
//                statement.setString(184, arg_eName);
//                statement.setString(185, arg_job);
//                statement.setFloat(186, arg_sal);
//                statement.setInt(187, arg_hireDate);
//                statement.setString(188, arg_language);
//                statement.setInt(189, arg_health);
//                statement.setString(190, arg_character);
//
//                statement.setInt(191, arg_id);
//                statement.setInt(192, arg_deptNo);
//                statement.setInt(193, arg_empNo);
//                statement.setString(194, arg_eName);
//                statement.setString(195, arg_job);
//                statement.setFloat(196, arg_sal);
//                statement.setInt(197, arg_hireDate);
//                statement.setString(198, arg_language);
//                statement.setInt(199, arg_health);
//                statement.setString(200, arg_character);
//
//                statement.setTimestamp(201, create_time1);
//                statement.setDate(202, create_time0);

                statement.addBatch();
                num++;
                if (num != 0 && num % 200 == 0) {
                    statement.executeBatch();
                    con.commit();
                    statement.clearBatch();
                    num = 0;
                }
            }
            statement.executeBatch();
            con.commit();

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Employee> getDatas(long num) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < num; i++) {

            int arg_id = (int) (100000 + Math.random() * 1000000000);
            int arg_deptNo = (int) (100 + Math.random() * 100000);
            int arg_empNo = (int) (10000 + Math.random() * 2000000000);
            String arg_eName = "xiangqin_" + getRamdomDataASC(6) + "_test";
            String arg_job = "job_" + getRamdomDataASC(3);
            Float arg_sal = (float) (1000 + Math.random() * 1000000000);
            int arg_hireDate = (int) (20130101 + Math.random() * 80000);
            String arg_language = "language_" + getRamdomDataASC(5);
            int arg_health = (int) (Math.random() * 2);
            String arg_character = "character_" + getRamdomDataASC(7);

            Employee emp = new Employee();

            emp.setId(UUID.randomUUID().toString());
            emp.setDeptNo(arg_deptNo);
            emp.setEmpNo(arg_empNo);
            emp.seteName(arg_eName);
            emp.setJob(arg_job);
            emp.setSal(arg_sal);
            emp.setHireDate(arg_hireDate);
            emp.setLanguage(arg_language);
            emp.setHealth(arg_health);
            emp.setCharacter(arg_character);
            emp.setId0(arg_id);
            emp.setDeptNo0(arg_deptNo);
            emp.setEmpNo0(arg_empNo);
            emp.seteName0(arg_eName);
            emp.setJob0(arg_job);
            emp.setSal0(arg_sal);
            emp.setHireDate0(arg_hireDate);
            emp.setLanguage0(arg_language);
            emp.setHealth0(arg_health);
            emp.setCharacter0(arg_character);

            emp.setId1(arg_id);
            emp.setDeptNo1(arg_deptNo);
            emp.setEmpNo1(arg_empNo);
            emp.seteName1(arg_eName);
            emp.setJob1(arg_job);
            emp.setSal1(arg_sal);
            emp.setHireDate1(arg_hireDate);
            emp.setLanguage1(arg_language);
            emp.setHealth1(arg_health);
            emp.setCharacter1(arg_character);

            emp.setId2(arg_id);
            emp.setDeptNo2(arg_deptNo);
            emp.setEmpNo2(arg_empNo);
            emp.seteName2(arg_eName);
            emp.setJob2(arg_job);
            emp.setSal2(arg_sal);
            emp.setHireDate2(arg_hireDate);
            emp.setLanguage2(arg_language);
            emp.setHealth2(arg_health);
            emp.setCharacter2(arg_character);

            emp.setId3(arg_id);
            emp.setDeptNo3(arg_deptNo);
            emp.setEmpNo3(arg_empNo);
            emp.seteName3(arg_eName);
            emp.setJob3(arg_job);
            emp.setSal3(arg_sal);
            emp.setHireDate3(arg_hireDate);
            emp.setLanguage3(arg_language);
            emp.setHealth3(arg_health);
            emp.setCharacter3(arg_character);

            emp.setId4(arg_id);
            emp.setDeptNo4(arg_deptNo);
            emp.setEmpNo4(arg_empNo);
            emp.seteName4(arg_eName);
            emp.setJob4(arg_job);
            emp.setSal4(arg_sal);
            emp.setHireDate4(arg_hireDate);
            emp.setLanguage4(arg_language);
            emp.setHealth4(arg_health);
            emp.setCharacter4(arg_character);

            emp.setId5(arg_id);
            emp.setDeptNo5(arg_deptNo);
            emp.setEmpNo5(arg_empNo);
            emp.seteName5(arg_eName);
            emp.setJob5(arg_job);
            emp.setSal5(arg_sal);
            emp.setHireDate5(arg_hireDate);
            emp.setLanguage5(arg_language);
            emp.setHealth5(arg_health);
            emp.setCharacter5(arg_character);

            emp.setId6(arg_id);
            emp.setDeptNo6(arg_deptNo);
            emp.setEmpNo6(arg_empNo);
            emp.seteName6(arg_eName);
            emp.setJob6(arg_job);
            emp.setSal6(arg_sal);
            emp.setHireDate6(arg_hireDate);
            emp.setLanguage6(arg_language);
            emp.setHealth6(arg_health);
            emp.setCharacter6(arg_character);

            emp.setId7(arg_id);
            emp.setDeptNo7(arg_deptNo);
            emp.setEmpNo7(arg_empNo);
            emp.seteName7(arg_eName);
            emp.setJob7(arg_job);
            emp.setSal7(arg_sal);
            emp.setHireDate7(arg_hireDate);
            emp.setLanguage7(arg_language);
            emp.setHealth7(arg_health);
            emp.setCharacter7(arg_character);

            emp.setId8(arg_id);
            emp.setDeptNo8(arg_deptNo);
            emp.setEmpNo8(arg_empNo);
            emp.seteName8(arg_eName);
            emp.setJob8(arg_job);
            emp.setSal8(arg_sal);
            emp.setHireDate8(arg_hireDate);
            emp.setLanguage8(arg_language);
            emp.setHealth8(arg_health);
            emp.setCharacter8(arg_character);

            emp.setId9(arg_id);
            emp.setDeptNo9(arg_deptNo);
            emp.setEmpNo9(arg_empNo);
            emp.seteName9(arg_eName);
            emp.setJob9(arg_job);
            emp.setSal9(arg_sal);
            emp.setHireDate9(arg_hireDate);
            emp.setLanguage9(arg_language);
            emp.setHealth9(arg_health);
            emp.setCharacter9(arg_character);


            emp.setId10(arg_id);
            emp.setDeptNo10(arg_deptNo);
            emp.setEmpNo10(arg_empNo);
            emp.seteName10(arg_eName);
            emp.setJob10(arg_job);
            emp.setSal10(arg_sal);
            emp.setHireDate10(arg_hireDate);
            emp.setLanguage10(arg_language);
            emp.setHealth10(arg_health);
            emp.setCharacter10(arg_character);

            emp.setId11(arg_id);
            emp.setDeptNo11(arg_deptNo);
            emp.setEmpNo11(arg_empNo);
            emp.seteName11(arg_eName);
            emp.setJob11(arg_job);
            emp.setSal11(arg_sal);
            emp.setHireDate11(arg_hireDate);
            emp.setLanguage11(arg_language);
            emp.setHealth11(arg_health);
            emp.setCharacter11(arg_character);

            emp.setId12(arg_id);
            emp.setDeptNo12(arg_deptNo);
            emp.setEmpNo12(arg_empNo);
            emp.seteName12(arg_eName);
            emp.setJob12(arg_job);
            emp.setSal12(arg_sal);
            emp.setHireDate12(arg_hireDate);
            emp.setLanguage12(arg_language);
            emp.setHealth12(arg_health);
            emp.setCharacter12(arg_character);

            emp.setId13(arg_id);
            emp.setDeptNo13(arg_deptNo);
            emp.setEmpNo13(arg_empNo);
            emp.seteName13(arg_eName);
            emp.setJob13(arg_job);
            emp.setSal13(arg_sal);
            emp.setHireDate13(arg_hireDate);
            emp.setLanguage13(arg_language);
            emp.setHealth13(arg_health);
            emp.setCharacter13(arg_character);

            emp.setId14(arg_id);
            emp.setDeptNo14(arg_deptNo);
            emp.setEmpNo14(arg_empNo);
            emp.seteName14(arg_eName);
            emp.setJob14(arg_job);
            emp.setSal14(arg_sal);
            emp.setHireDate14(arg_hireDate);
            emp.setLanguage14(arg_language);
            emp.setHealth14(arg_health);
            emp.setCharacter14(arg_character);

            emp.setId15(arg_id);
            emp.setDeptNo15(arg_deptNo);
            emp.setEmpNo15(arg_empNo);
            emp.seteName15(arg_eName);
            emp.setJob15(arg_job);
            emp.setSal15(arg_sal);
            emp.setHireDate15(arg_hireDate);
            emp.setLanguage15(arg_language);
            emp.setHealth15(arg_health);
            emp.setCharacter15(arg_character);

            emp.setId16(arg_id);
            emp.setDeptNo16(arg_deptNo);
            emp.setEmpNo16(arg_empNo);
            emp.seteName16(arg_eName);
            emp.setJob16(arg_job);
            emp.setSal16(arg_sal);
            emp.setHireDate16(arg_hireDate);
            emp.setLanguage16(arg_language);
            emp.setHealth16(arg_health);
            emp.setCharacter16(arg_character);

            emp.setId17(arg_id);
            emp.setDeptNo17(arg_deptNo);
            emp.setEmpNo17(arg_empNo);
            emp.seteName17(arg_eName);
            emp.setJob17(arg_job);
            emp.setSal17(arg_sal);
            emp.setHireDate17(arg_hireDate);
            emp.setLanguage17(arg_language);
            emp.setHealth17(arg_health);
            emp.setCharacter17(arg_character);

            emp.setId18(arg_id);
            emp.setDeptNo18(arg_deptNo);
            emp.setEmpNo18(arg_empNo);
            emp.seteName18(arg_eName);
            emp.setJob18(arg_job);
            emp.setSal18(arg_sal);
            emp.setHireDate18(arg_hireDate);
            emp.setLanguage18(arg_language);
            emp.setHealth18(arg_health);
            emp.setCharacter18(arg_character);

            employeeList.add(emp);
        }

        return employeeList;
    }


    protected String getRamdomDataASC(int size) {
        String ret = "";
        String str[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < size; i++) {
            int index = new Random().nextInt(26);
            ret += str[index];
        }
        return ret;
    }

}
