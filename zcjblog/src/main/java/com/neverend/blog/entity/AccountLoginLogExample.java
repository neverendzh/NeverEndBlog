package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountLoginLogExample() {
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

        public Criteria andLoginIpIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("login_ip =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("login_ip <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("login_ip >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("login_ip >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("login_ip <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("login_ip <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("login_ip like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("login_ip not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("login_ip in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("login_ip not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("login_ip between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("login_ip not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
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