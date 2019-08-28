package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberIsNull() {
            addCriterion("cellphone_number is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberIsNotNull() {
            addCriterion("cellphone_number is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberEqualTo(String value) {
            addCriterion("cellphone_number =", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberNotEqualTo(String value) {
            addCriterion("cellphone_number <>", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberGreaterThan(String value) {
            addCriterion("cellphone_number >", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone_number >=", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberLessThan(String value) {
            addCriterion("cellphone_number <", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberLessThanOrEqualTo(String value) {
            addCriterion("cellphone_number <=", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberLike(String value) {
            addCriterion("cellphone_number like", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberNotLike(String value) {
            addCriterion("cellphone_number not like", value, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberIn(List<String> values) {
            addCriterion("cellphone_number in", values, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberNotIn(List<String> values) {
            addCriterion("cellphone_number not in", values, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberBetween(String value1, String value2) {
            addCriterion("cellphone_number between", value1, value2, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andCellphoneNumberNotBetween(String value1, String value2) {
            addCriterion("cellphone_number not between", value1, value2, "cellphoneNumber");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
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

        public Criteria andLoginEndTimeIsNull() {
            addCriterion("login_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeIsNotNull() {
            addCriterion("login_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeEqualTo(Date value) {
            addCriterion("login_end_time =", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeNotEqualTo(Date value) {
            addCriterion("login_end_time <>", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeGreaterThan(Date value) {
            addCriterion("login_end_time >", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_end_time >=", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeLessThan(Date value) {
            addCriterion("login_end_time <", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_end_time <=", value, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeIn(List<Date> values) {
            addCriterion("login_end_time in", values, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeNotIn(List<Date> values) {
            addCriterion("login_end_time not in", values, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeBetween(Date value1, Date value2) {
            addCriterion("login_end_time between", value1, value2, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andLoginEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_end_time not between", value1, value2, "loginEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNull() {
            addCriterion("account_state is null");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNotNull() {
            addCriterion("account_state is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStateEqualTo(String value) {
            addCriterion("account_state =", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotEqualTo(String value) {
            addCriterion("account_state <>", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThan(String value) {
            addCriterion("account_state >", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThanOrEqualTo(String value) {
            addCriterion("account_state >=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThan(String value) {
            addCriterion("account_state <", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThanOrEqualTo(String value) {
            addCriterion("account_state <=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLike(String value) {
            addCriterion("account_state like", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotLike(String value) {
            addCriterion("account_state not like", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateIn(List<String> values) {
            addCriterion("account_state in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotIn(List<String> values) {
            addCriterion("account_state not in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateBetween(String value1, String value2) {
            addCriterion("account_state between", value1, value2, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotBetween(String value1, String value2) {
            addCriterion("account_state not between", value1, value2, "accountState");
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

        public Criteria andBeiYongLiuIsNull() {
            addCriterion("bei_yong_liu is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuIsNotNull() {
            addCriterion("bei_yong_liu is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuEqualTo(String value) {
            addCriterion("bei_yong_liu =", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuNotEqualTo(String value) {
            addCriterion("bei_yong_liu <>", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuGreaterThan(String value) {
            addCriterion("bei_yong_liu >", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_liu >=", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuLessThan(String value) {
            addCriterion("bei_yong_liu <", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_liu <=", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuLike(String value) {
            addCriterion("bei_yong_liu like", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuNotLike(String value) {
            addCriterion("bei_yong_liu not like", value, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuIn(List<String> values) {
            addCriterion("bei_yong_liu in", values, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuNotIn(List<String> values) {
            addCriterion("bei_yong_liu not in", values, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuBetween(String value1, String value2) {
            addCriterion("bei_yong_liu between", value1, value2, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongLiuNotBetween(String value1, String value2) {
            addCriterion("bei_yong_liu not between", value1, value2, "beiYongLiu");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiIsNull() {
            addCriterion("bei_yong_qi is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiIsNotNull() {
            addCriterion("bei_yong_qi is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiEqualTo(String value) {
            addCriterion("bei_yong_qi =", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiNotEqualTo(String value) {
            addCriterion("bei_yong_qi <>", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiGreaterThan(String value) {
            addCriterion("bei_yong_qi >", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_qi >=", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiLessThan(String value) {
            addCriterion("bei_yong_qi <", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_qi <=", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiLike(String value) {
            addCriterion("bei_yong_qi like", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiNotLike(String value) {
            addCriterion("bei_yong_qi not like", value, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiIn(List<String> values) {
            addCriterion("bei_yong_qi in", values, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiNotIn(List<String> values) {
            addCriterion("bei_yong_qi not in", values, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiBetween(String value1, String value2) {
            addCriterion("bei_yong_qi between", value1, value2, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongQiNotBetween(String value1, String value2) {
            addCriterion("bei_yong_qi not between", value1, value2, "beiYongQi");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaIsNull() {
            addCriterion("bei_yong_ba is null");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaIsNotNull() {
            addCriterion("bei_yong_ba is not null");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaEqualTo(String value) {
            addCriterion("bei_yong_ba =", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaNotEqualTo(String value) {
            addCriterion("bei_yong_ba <>", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaGreaterThan(String value) {
            addCriterion("bei_yong_ba >", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaGreaterThanOrEqualTo(String value) {
            addCriterion("bei_yong_ba >=", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaLessThan(String value) {
            addCriterion("bei_yong_ba <", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaLessThanOrEqualTo(String value) {
            addCriterion("bei_yong_ba <=", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaLike(String value) {
            addCriterion("bei_yong_ba like", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaNotLike(String value) {
            addCriterion("bei_yong_ba not like", value, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaIn(List<String> values) {
            addCriterion("bei_yong_ba in", values, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaNotIn(List<String> values) {
            addCriterion("bei_yong_ba not in", values, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaBetween(String value1, String value2) {
            addCriterion("bei_yong_ba between", value1, value2, "beiYongBa");
            return (Criteria) this;
        }

        public Criteria andBeiYongBaNotBetween(String value1, String value2) {
            addCriterion("bei_yong_ba not between", value1, value2, "beiYongBa");
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