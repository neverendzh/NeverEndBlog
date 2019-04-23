package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuperArticleSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuperArticleSortExample() {
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

        public Criteria andSuperArticleSortIdIsNull() {
            addCriterion("super_article_sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdIsNotNull() {
            addCriterion("super_article_sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdEqualTo(String value) {
            addCriterion("super_article_sort_id =", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdNotEqualTo(String value) {
            addCriterion("super_article_sort_id <>", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdGreaterThan(String value) {
            addCriterion("super_article_sort_id >", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdGreaterThanOrEqualTo(String value) {
            addCriterion("super_article_sort_id >=", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdLessThan(String value) {
            addCriterion("super_article_sort_id <", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdLessThanOrEqualTo(String value) {
            addCriterion("super_article_sort_id <=", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdLike(String value) {
            addCriterion("super_article_sort_id like", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdNotLike(String value) {
            addCriterion("super_article_sort_id not like", value, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdIn(List<String> values) {
            addCriterion("super_article_sort_id in", values, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdNotIn(List<String> values) {
            addCriterion("super_article_sort_id not in", values, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdBetween(String value1, String value2) {
            addCriterion("super_article_sort_id between", value1, value2, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArticleSortIdNotBetween(String value1, String value2) {
            addCriterion("super_article_sort_id not between", value1, value2, "superArticleSortId");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameIsNull() {
            addCriterion("super_artilce_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameIsNotNull() {
            addCriterion("super_artilce_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameEqualTo(String value) {
            addCriterion("super_artilce_name =", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameNotEqualTo(String value) {
            addCriterion("super_artilce_name <>", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameGreaterThan(String value) {
            addCriterion("super_artilce_name >", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameGreaterThanOrEqualTo(String value) {
            addCriterion("super_artilce_name >=", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameLessThan(String value) {
            addCriterion("super_artilce_name <", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameLessThanOrEqualTo(String value) {
            addCriterion("super_artilce_name <=", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameLike(String value) {
            addCriterion("super_artilce_name like", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameNotLike(String value) {
            addCriterion("super_artilce_name not like", value, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameIn(List<String> values) {
            addCriterion("super_artilce_name in", values, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameNotIn(List<String> values) {
            addCriterion("super_artilce_name not in", values, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameBetween(String value1, String value2) {
            addCriterion("super_artilce_name between", value1, value2, "superArtilceName");
            return (Criteria) this;
        }

        public Criteria andSuperArtilceNameNotBetween(String value1, String value2) {
            addCriterion("super_artilce_name not between", value1, value2, "superArtilceName");
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

        public Criteria andToUpdateIsNull() {
            addCriterion("to_update is null");
            return (Criteria) this;
        }

        public Criteria andToUpdateIsNotNull() {
            addCriterion("to_update is not null");
            return (Criteria) this;
        }

        public Criteria andToUpdateEqualTo(Date value) {
            addCriterion("to_update =", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateNotEqualTo(Date value) {
            addCriterion("to_update <>", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateGreaterThan(Date value) {
            addCriterion("to_update >", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("to_update >=", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateLessThan(Date value) {
            addCriterion("to_update <", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateLessThanOrEqualTo(Date value) {
            addCriterion("to_update <=", value, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateIn(List<Date> values) {
            addCriterion("to_update in", values, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateNotIn(List<Date> values) {
            addCriterion("to_update not in", values, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateBetween(Date value1, Date value2) {
            addCriterion("to_update between", value1, value2, "toUpdate");
            return (Criteria) this;
        }

        public Criteria andToUpdateNotBetween(Date value1, Date value2) {
            addCriterion("to_update not between", value1, value2, "toUpdate");
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