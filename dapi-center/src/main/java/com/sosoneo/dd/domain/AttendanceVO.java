package com.sosoneo.dd.domain;

public class AttendanceVO {
    /**
     * 员工id
     */
    public String userid;
    /**
     * 审批单类型
     *
     * 1:加班，2：外出、出差，3：请假
     */
    public Integer bizType;
    /**
     * 开始时间，不能早于当前时间前31天，支持的时间格式如下：
     *
     * （1）2019-08-15
     *
     * （2）2019-08-15 AM
     *
     * （3）2019-08-15 12:43
     */
    public String fromTime;
    /**
     * 结束时间，结束时间减去开始时间的天数不能超过31天，biz_type为1时结束时间减去开始时间不能超过1天，支持的时间格式如下：
     *
     * （1）2019-08-15
     *
     * （2）2019-08-15 AM
     *
     * （3）2019-08-15 12:43
     */
    public String toTime;
    /**
     *
     * 时长单位，支持的格式如下：
     *
     * （1）day
     *
     * （2）halfDay
     *
     * （3）hour
     *
     * biz_type为1时仅支持hour
     *
     * 时间格式必须与时长单位对应
     *
     * （1）2019-08-15对应day
     *
     * （2）2019-08-15 AM对应halfDay
     *
     * （3）2019-08-15 12:43对应hour
     */
    public String durationUnit;
    /**
     * 计算方法
     *
     * 0：按自然日计算，1：按工作日计
     */
    public Integer calculateModel;
    /**
     * 审批单类型名称，最大长度20个字符；
     *
     * 支持的类型名称：请假、出差、外出、加班
     */
    public String tagName;
    /**
     * 子类型名称，最大长度20个字符
     */
    public String subType;
    /**
     * 审批单全局唯一id，最大长度100个字符
     */
    public String approveId;
    /**
     * 审批单跳转地址，最大长度200个字符
     */
    public String jumpUrl;
    /**
     * biz_type为1时必传，加班时长单位小时
     */
    public String overtimeDuration;
    /**
     *
     * biz_type为1时必传
     *
     * 1：加班转调休，2：加班转工资
     */
    public String overtimeToMore;

    /**
     * 将审批实例转换为假勤实例
     * @param processInstance
     * @return
     */
    public AttendanceVO processInstance2Attendance(ProcessInstanceInputVO processInstance) {
        AttendanceVO attendance = new AttendanceVO();
        return attendance;
    }
}
