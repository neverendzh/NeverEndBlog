package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QiNiuKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QiNiuKeyExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAkIsNull() {
            addCriterion("ak is null");
            return (Criteria) this;
        }

        public Criteria andAkIsNotNull() {
            addCriterion("ak is not null");
            return (Criteria) this;
        }

        public Criteria andAkEqualTo(String value) {
            addCriterion("ak =", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkNotEqualTo(String value) {
            addCriterion("ak <>", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkGreaterThan(String value) {
            addCriterion("ak >", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkGreaterThanOrEqualTo(String value) {
            addCriterion("ak >=", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkLessThan(String value) {
            addCriterion("ak <", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkLessThanOrEqualTo(String value) {
            addCriterion("ak <=", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkLike(String value) {
            addCriterion("ak like", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkNotLike(String value) {
            addCriterion("ak not like", value, "ak");
            return (Criteria) this;
        }

        public Criteria andAkIn(List<String> values) {
            addCriterion("ak in", values, "ak");
            return (Criteria) this;
        }

        public Criteria andAkNotIn(List<String> values) {
            addCriterion("ak not in", values, "ak");
            return (Criteria) this;
        }

        public Criteria andAkBetween(String value1, String value2) {
            addCriterion("ak between", value1, value2, "ak");
            return (Criteria) this;
        }

        public Criteria andAkNotBetween(String value1, String value2) {
            addCriterion("ak not between", value1, value2, "ak");
            return (Criteria) this;
        }

        public Criteria andSkIsNull() {
            addCriterion("sk is null");
            return (Criteria) this;
        }

        public Criteria andSkIsNotNull() {
            addCriterion("sk is not null");
            return (Criteria) this;
        }

        public Criteria andSkEqualTo(String value) {
            addCriterion("sk =", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkNotEqualTo(String value) {
            addCriterion("sk <>", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkGreaterThan(String value) {
            addCriterion("sk >", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkGreaterThanOrEqualTo(String value) {
            addCriterion("sk >=", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkLessThan(String value) {
            addCriterion("sk <", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkLessThanOrEqualTo(String value) {
            addCriterion("sk <=", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkLike(String value) {
            addCriterion("sk like", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkNotLike(String value) {
            addCriterion("sk not like", value, "sk");
            return (Criteria) this;
        }

        public Criteria andSkIn(List<String> values) {
            addCriterion("sk in", values, "sk");
            return (Criteria) this;
        }

        public Criteria andSkNotIn(List<String> values) {
            addCriterion("sk not in", values, "sk");
            return (Criteria) this;
        }

        public Criteria andSkBetween(String value1, String value2) {
            addCriterion("sk between", value1, value2, "sk");
            return (Criteria) this;
        }

        public Criteria andSkNotBetween(String value1, String value2) {
            addCriterion("sk not between", value1, value2, "sk");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameIsNull() {
            addCriterion("qi_niu_name is null");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameIsNotNull() {
            addCriterion("qi_niu_name is not null");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameEqualTo(String value) {
            addCriterion("qi_niu_name =", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameNotEqualTo(String value) {
            addCriterion("qi_niu_name <>", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameGreaterThan(String value) {
            addCriterion("qi_niu_name >", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameGreaterThanOrEqualTo(String value) {
            addCriterion("qi_niu_name >=", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameLessThan(String value) {
            addCriterion("qi_niu_name <", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameLessThanOrEqualTo(String value) {
            addCriterion("qi_niu_name <=", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameLike(String value) {
            addCriterion("qi_niu_name like", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameNotLike(String value) {
            addCriterion("qi_niu_name not like", value, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameIn(List<String> values) {
            addCriterion("qi_niu_name in", values, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameNotIn(List<String> values) {
            addCriterion("qi_niu_name not in", values, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameBetween(String value1, String value2) {
            addCriterion("qi_niu_name between", value1, value2, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andQiNiuNameNotBetween(String value1, String value2) {
            addCriterion("qi_niu_name not between", value1, value2, "qiNiuName");
            return (Criteria) this;
        }

        public Criteria andYuMingIsNull() {
            addCriterion("yu_ming is null");
            return (Criteria) this;
        }

        public Criteria andYuMingIsNotNull() {
            addCriterion("yu_ming is not null");
            return (Criteria) this;
        }

        public Criteria andYuMingEqualTo(String value) {
            addCriterion("yu_ming =", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingNotEqualTo(String value) {
            addCriterion("yu_ming <>", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingGreaterThan(String value) {
            addCriterion("yu_ming >", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingGreaterThanOrEqualTo(String value) {
            addCriterion("yu_ming >=", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingLessThan(String value) {
            addCriterion("yu_ming <", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingLessThanOrEqualTo(String value) {
            addCriterion("yu_ming <=", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingLike(String value) {
            addCriterion("yu_ming like", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingNotLike(String value) {
            addCriterion("yu_ming not like", value, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingIn(List<String> values) {
            addCriterion("yu_ming in", values, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingNotIn(List<String> values) {
            addCriterion("yu_ming not in", values, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingBetween(String value1, String value2) {
            addCriterion("yu_ming between", value1, value2, "yuMing");
            return (Criteria) this;
        }

        public Criteria andYuMingNotBetween(String value1, String value2) {
            addCriterion("yu_ming not between", value1, value2, "yuMing");
            return (Criteria) this;
        }

        public Criteria andEreattimeIsNull() {
            addCriterion("ereatTime is null");
            return (Criteria) this;
        }

        public Criteria andEreattimeIsNotNull() {
            addCriterion("ereatTime is not null");
            return (Criteria) this;
        }

        public Criteria andEreattimeEqualTo(Date value) {
            addCriterion("ereatTime =", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeNotEqualTo(Date value) {
            addCriterion("ereatTime <>", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeGreaterThan(Date value) {
            addCriterion("ereatTime >", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ereatTime >=", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeLessThan(Date value) {
            addCriterion("ereatTime <", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeLessThanOrEqualTo(Date value) {
            addCriterion("ereatTime <=", value, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeIn(List<Date> values) {
            addCriterion("ereatTime in", values, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeNotIn(List<Date> values) {
            addCriterion("ereatTime not in", values, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeBetween(Date value1, Date value2) {
            addCriterion("ereatTime between", value1, value2, "ereattime");
            return (Criteria) this;
        }

        public Criteria andEreattimeNotBetween(Date value1, Date value2) {
            addCriterion("ereatTime not between", value1, value2, "ereattime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(Integer value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(Integer value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(Integer value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(Integer value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(Integer value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<Integer> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<Integer> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(Integer value1, Integer value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andBeiYiIsNull() {
            addCriterion("bei_yi is null");
            return (Criteria) this;
        }

        public Criteria andBeiYiIsNotNull() {
            addCriterion("bei_yi is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYiEqualTo(String value) {
            addCriterion("bei_yi =", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiNotEqualTo(String value) {
            addCriterion("bei_yi <>", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiGreaterThan(String value) {
            addCriterion("bei_yi >", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yi >=", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiLessThan(String value) {
            addCriterion("bei_yi <", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiLessThanOrEqualTo(String value) {
            addCriterion("bei_yi <=", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiLike(String value) {
            addCriterion("bei_yi like", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiNotLike(String value) {
            addCriterion("bei_yi not like", value, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiIn(List<String> values) {
            addCriterion("bei_yi in", values, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiNotIn(List<String> values) {
            addCriterion("bei_yi not in", values, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiBetween(String value1, String value2) {
            addCriterion("bei_yi between", value1, value2, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBeiYiNotBetween(String value1, String value2) {
            addCriterion("bei_yi not between", value1, value2, "beiYi");
            return (Criteria) this;
        }

        public Criteria andBieErIsNull() {
            addCriterion("bie_er is null");
            return (Criteria) this;
        }

        public Criteria andBieErIsNotNull() {
            addCriterion("bie_er is not null");
            return (Criteria) this;
        }

        public Criteria andBieErEqualTo(String value) {
            addCriterion("bie_er =", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErNotEqualTo(String value) {
            addCriterion("bie_er <>", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErGreaterThan(String value) {
            addCriterion("bie_er >", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErGreaterThanOrEqualTo(String value) {
            addCriterion("bie_er >=", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErLessThan(String value) {
            addCriterion("bie_er <", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErLessThanOrEqualTo(String value) {
            addCriterion("bie_er <=", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErLike(String value) {
            addCriterion("bie_er like", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErNotLike(String value) {
            addCriterion("bie_er not like", value, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErIn(List<String> values) {
            addCriterion("bie_er in", values, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErNotIn(List<String> values) {
            addCriterion("bie_er not in", values, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErBetween(String value1, String value2) {
            addCriterion("bie_er between", value1, value2, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieErNotBetween(String value1, String value2) {
            addCriterion("bie_er not between", value1, value2, "bieEr");
            return (Criteria) this;
        }

        public Criteria andBieSanIsNull() {
            addCriterion("bie_san is null");
            return (Criteria) this;
        }

        public Criteria andBieSanIsNotNull() {
            addCriterion("bie_san is not null");
            return (Criteria) this;
        }

        public Criteria andBieSanEqualTo(String value) {
            addCriterion("bie_san =", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanNotEqualTo(String value) {
            addCriterion("bie_san <>", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanGreaterThan(String value) {
            addCriterion("bie_san >", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanGreaterThanOrEqualTo(String value) {
            addCriterion("bie_san >=", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanLessThan(String value) {
            addCriterion("bie_san <", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanLessThanOrEqualTo(String value) {
            addCriterion("bie_san <=", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanLike(String value) {
            addCriterion("bie_san like", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanNotLike(String value) {
            addCriterion("bie_san not like", value, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanIn(List<String> values) {
            addCriterion("bie_san in", values, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanNotIn(List<String> values) {
            addCriterion("bie_san not in", values, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanBetween(String value1, String value2) {
            addCriterion("bie_san between", value1, value2, "bieSan");
            return (Criteria) this;
        }

        public Criteria andBieSanNotBetween(String value1, String value2) {
            addCriterion("bie_san not between", value1, value2, "bieSan");
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