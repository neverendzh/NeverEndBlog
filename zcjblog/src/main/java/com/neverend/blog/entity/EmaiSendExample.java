package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmaiSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmaiSendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberIsNull() {
            addCriterion("send_email_number is null");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberIsNotNull() {
            addCriterion("send_email_number is not null");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberEqualTo(String value) {
            addCriterion("send_email_number =", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberNotEqualTo(String value) {
            addCriterion("send_email_number <>", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberGreaterThan(String value) {
            addCriterion("send_email_number >", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberGreaterThanOrEqualTo(String value) {
            addCriterion("send_email_number >=", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberLessThan(String value) {
            addCriterion("send_email_number <", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberLessThanOrEqualTo(String value) {
            addCriterion("send_email_number <=", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberLike(String value) {
            addCriterion("send_email_number like", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberNotLike(String value) {
            addCriterion("send_email_number not like", value, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberIn(List<String> values) {
            addCriterion("send_email_number in", values, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberNotIn(List<String> values) {
            addCriterion("send_email_number not in", values, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberBetween(String value1, String value2) {
            addCriterion("send_email_number between", value1, value2, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andSendEmailNumberNotBetween(String value1, String value2) {
            addCriterion("send_email_number not between", value1, value2, "sendEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberIsNull() {
            addCriterion("revenue_email_number is null");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberIsNotNull() {
            addCriterion("revenue_email_number is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberEqualTo(String value) {
            addCriterion("revenue_email_number =", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberNotEqualTo(String value) {
            addCriterion("revenue_email_number <>", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberGreaterThan(String value) {
            addCriterion("revenue_email_number >", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberGreaterThanOrEqualTo(String value) {
            addCriterion("revenue_email_number >=", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberLessThan(String value) {
            addCriterion("revenue_email_number <", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberLessThanOrEqualTo(String value) {
            addCriterion("revenue_email_number <=", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberLike(String value) {
            addCriterion("revenue_email_number like", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberNotLike(String value) {
            addCriterion("revenue_email_number not like", value, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberIn(List<String> values) {
            addCriterion("revenue_email_number in", values, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberNotIn(List<String> values) {
            addCriterion("revenue_email_number not in", values, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberBetween(String value1, String value2) {
            addCriterion("revenue_email_number between", value1, value2, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andRevenueEmailNumberNotBetween(String value1, String value2) {
            addCriterion("revenue_email_number not between", value1, value2, "revenueEmailNumber");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIsNull() {
            addCriterion("email_subject is null");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIsNotNull() {
            addCriterion("email_subject is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectEqualTo(String value) {
            addCriterion("email_subject =", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotEqualTo(String value) {
            addCriterion("email_subject <>", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectGreaterThan(String value) {
            addCriterion("email_subject >", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("email_subject >=", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLessThan(String value) {
            addCriterion("email_subject <", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLessThanOrEqualTo(String value) {
            addCriterion("email_subject <=", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectLike(String value) {
            addCriterion("email_subject like", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotLike(String value) {
            addCriterion("email_subject not like", value, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectIn(List<String> values) {
            addCriterion("email_subject in", values, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotIn(List<String> values) {
            addCriterion("email_subject not in", values, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectBetween(String value1, String value2) {
            addCriterion("email_subject between", value1, value2, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailSubjectNotBetween(String value1, String value2) {
            addCriterion("email_subject not between", value1, value2, "emailSubject");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianIsNull() {
            addCriterion("email_fu_jian is null");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianIsNotNull() {
            addCriterion("email_fu_jian is not null");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianEqualTo(String value) {
            addCriterion("email_fu_jian =", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianNotEqualTo(String value) {
            addCriterion("email_fu_jian <>", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianGreaterThan(String value) {
            addCriterion("email_fu_jian >", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianGreaterThanOrEqualTo(String value) {
            addCriterion("email_fu_jian >=", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianLessThan(String value) {
            addCriterion("email_fu_jian <", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianLessThanOrEqualTo(String value) {
            addCriterion("email_fu_jian <=", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianLike(String value) {
            addCriterion("email_fu_jian like", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianNotLike(String value) {
            addCriterion("email_fu_jian not like", value, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianIn(List<String> values) {
            addCriterion("email_fu_jian in", values, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianNotIn(List<String> values) {
            addCriterion("email_fu_jian not in", values, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianBetween(String value1, String value2) {
            addCriterion("email_fu_jian between", value1, value2, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andEmailFuJianNotBetween(String value1, String value2) {
            addCriterion("email_fu_jian not between", value1, value2, "emailFuJian");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeIsNull() {
            addCriterion("bei_yong_time is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeIsNotNull() {
            addCriterion("bei_yong_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeEqualTo(Date value) {
            addCriterion("bei_yong_time =", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeNotEqualTo(Date value) {
            addCriterion("bei_yong_time <>", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeGreaterThan(Date value) {
            addCriterion("bei_yong_time >", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bei_yong_time >=", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeLessThan(Date value) {
            addCriterion("bei_yong_time <", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeLessThanOrEqualTo(Date value) {
            addCriterion("bei_yong_time <=", value, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeIn(List<Date> values) {
            addCriterion("bei_yong_time in", values, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeNotIn(List<Date> values) {
            addCriterion("bei_yong_time not in", values, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeBetween(Date value1, Date value2) {
            addCriterion("bei_yong_time between", value1, value2, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andBeiYongTimeNotBetween(Date value1, Date value2) {
            addCriterion("bei_yong_time not between", value1, value2, "beiYongTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiIsNull() {
            addCriterion("bei_yong_yi is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiIsNotNull() {
            addCriterion("bei_yong_yi is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiEqualTo(String value) {
            addCriterion("bei_yong_yi =", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiNotEqualTo(String value) {
            addCriterion("bei_yong_yi <>", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiGreaterThan(String value) {
            addCriterion("bei_yong_yi >", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_yi >=", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiLessThan(String value) {
            addCriterion("bei_yong_yi <", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_yi <=", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiLike(String value) {
            addCriterion("bei_yong_yi like", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiNotLike(String value) {
            addCriterion("bei_yong_yi not like", value, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiIn(List<String> values) {
            addCriterion("bei_yong_yi in", values, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiNotIn(List<String> values) {
            addCriterion("bei_yong_yi not in", values, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiBetween(String value1, String value2) {
            addCriterion("bei_yong_yi between", value1, value2, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongYiNotBetween(String value1, String value2) {
            addCriterion("bei_yong_yi not between", value1, value2, "beiYongYi");
            return (Criteria) this;
        }

        public Criteria andBeiYongErIsNull() {
            addCriterion("bei_yong_er is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongErIsNotNull() {
            addCriterion("bei_yong_er is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongErEqualTo(String value) {
            addCriterion("bei_yong_er =", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErNotEqualTo(String value) {
            addCriterion("bei_yong_er <>", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErGreaterThan(String value) {
            addCriterion("bei_yong_er >", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_er >=", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErLessThan(String value) {
            addCriterion("bei_yong_er <", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_er <=", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErLike(String value) {
            addCriterion("bei_yong_er like", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErNotLike(String value) {
            addCriterion("bei_yong_er not like", value, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErIn(List<String> values) {
            addCriterion("bei_yong_er in", values, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErNotIn(List<String> values) {
            addCriterion("bei_yong_er not in", values, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErBetween(String value1, String value2) {
            addCriterion("bei_yong_er between", value1, value2, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongErNotBetween(String value1, String value2) {
            addCriterion("bei_yong_er not between", value1, value2, "beiYongEr");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanIsNull() {
            addCriterion("bei_yong_san is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanIsNotNull() {
            addCriterion("bei_yong_san is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanEqualTo(String value) {
            addCriterion("bei_yong_san =", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanNotEqualTo(String value) {
            addCriterion("bei_yong_san <>", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanGreaterThan(String value) {
            addCriterion("bei_yong_san >", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_san >=", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanLessThan(String value) {
            addCriterion("bei_yong_san <", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_san <=", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanLike(String value) {
            addCriterion("bei_yong_san like", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanNotLike(String value) {
            addCriterion("bei_yong_san not like", value, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanIn(List<String> values) {
            addCriterion("bei_yong_san in", values, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanNotIn(List<String> values) {
            addCriterion("bei_yong_san not in", values, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanBetween(String value1, String value2) {
            addCriterion("bei_yong_san between", value1, value2, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSanNotBetween(String value1, String value2) {
            addCriterion("bei_yong_san not between", value1, value2, "beiYongSan");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiIsNull() {
            addCriterion("bei_yong_si is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiIsNotNull() {
            addCriterion("bei_yong_si is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiEqualTo(String value) {
            addCriterion("bei_yong_si =", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiNotEqualTo(String value) {
            addCriterion("bei_yong_si <>", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiGreaterThan(String value) {
            addCriterion("bei_yong_si >", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_si >=", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiLessThan(String value) {
            addCriterion("bei_yong_si <", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_si <=", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiLike(String value) {
            addCriterion("bei_yong_si like", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiNotLike(String value) {
            addCriterion("bei_yong_si not like", value, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiIn(List<String> values) {
            addCriterion("bei_yong_si in", values, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiNotIn(List<String> values) {
            addCriterion("bei_yong_si not in", values, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiBetween(String value1, String value2) {
            addCriterion("bei_yong_si between", value1, value2, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongSiNotBetween(String value1, String value2) {
            addCriterion("bei_yong_si not between", value1, value2, "beiYongSi");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuIsNull() {
            addCriterion("bei_yong_wu is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuIsNotNull() {
            addCriterion("bei_yong_wu is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuEqualTo(String value) {
            addCriterion("bei_yong_wu =", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuNotEqualTo(String value) {
            addCriterion("bei_yong_wu <>", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuGreaterThan(String value) {
            addCriterion("bei_yong_wu >", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_wu >=", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuLessThan(String value) {
            addCriterion("bei_yong_wu <", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_wu <=", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuLike(String value) {
            addCriterion("bei_yong_wu like", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuNotLike(String value) {
            addCriterion("bei_yong_wu not like", value, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuIn(List<String> values) {
            addCriterion("bei_yong_wu in", values, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuNotIn(List<String> values) {
            addCriterion("bei_yong_wu not in", values, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuBetween(String value1, String value2) {
            addCriterion("bei_yong_wu between", value1, value2, "beiYongWu");
            return (Criteria) this;
        }

        public Criteria andBeiYongWuNotBetween(String value1, String value2) {
            addCriterion("bei_yong_wu not between", value1, value2, "beiYongWu");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}