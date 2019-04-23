package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminEmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminEmailExample() {
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingIsNull() {
            addCriterion("password_ko_ling is null");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingIsNotNull() {
            addCriterion("password_ko_ling is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingEqualTo(String value) {
            addCriterion("password_ko_ling =", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingNotEqualTo(String value) {
            addCriterion("password_ko_ling <>", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingGreaterThan(String value) {
            addCriterion("password_ko_ling >", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingGreaterThanOrEqualTo(String value) {
            addCriterion("password_ko_ling >=", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingLessThan(String value) {
            addCriterion("password_ko_ling <", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingLessThanOrEqualTo(String value) {
            addCriterion("password_ko_ling <=", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingLike(String value) {
            addCriterion("password_ko_ling like", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingNotLike(String value) {
            addCriterion("password_ko_ling not like", value, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingIn(List<String> values) {
            addCriterion("password_ko_ling in", values, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingNotIn(List<String> values) {
            addCriterion("password_ko_ling not in", values, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingBetween(String value1, String value2) {
            addCriterion("password_ko_ling between", value1, value2, "passwordKoLing");
            return (Criteria) this;
        }

        public Criteria andPasswordKoLingNotBetween(String value1, String value2) {
            addCriterion("password_ko_ling not between", value1, value2, "passwordKoLing");
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

        public Criteria andHostIsNull() {
            addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(Integer value) {
            addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(Integer value) {
            addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(Integer value) {
            addCriterion("host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(Integer value) {
            addCriterion("host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(Integer value) {
            addCriterion("host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(Integer value) {
            addCriterion("host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<Integer> values) {
            addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<Integer> values) {
            addCriterion("host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(Integer value1, Integer value2) {
            addCriterion("host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(Integer value1, Integer value2) {
            addCriterion("host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIsNull() {
            addCriterion("send_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIsNotNull() {
            addCriterion("send_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeEqualTo(Date value) {
            addCriterion("send_end_time =", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotEqualTo(Date value) {
            addCriterion("send_end_time <>", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeGreaterThan(Date value) {
            addCriterion("send_end_time >", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_end_time >=", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeLessThan(Date value) {
            addCriterion("send_end_time <", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_end_time <=", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIn(List<Date> values) {
            addCriterion("send_end_time in", values, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotIn(List<Date> values) {
            addCriterion("send_end_time not in", values, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeBetween(Date value1, Date value2) {
            addCriterion("send_end_time between", value1, value2, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_end_time not between", value1, value2, "sendEndTime");
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