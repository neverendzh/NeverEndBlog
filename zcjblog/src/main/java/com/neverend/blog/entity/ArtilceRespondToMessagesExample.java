package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArtilceRespondToMessagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArtilceRespondToMessagesExample() {
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

        public Criteria andRespondToMessagesIdIsNull() {
            addCriterion("respond_to_messages_id is null");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIsNotNull() {
            addCriterion("respond_to_messages_id is not null");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdEqualTo(String value) {
            addCriterion("respond_to_messages_id =", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdNotEqualTo(String value) {
            addCriterion("respond_to_messages_id <>", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdGreaterThan(String value) {
            addCriterion("respond_to_messages_id >", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdGreaterThanOrEqualTo(String value) {
            addCriterion("respond_to_messages_id >=", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdLessThan(String value) {
            addCriterion("respond_to_messages_id <", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdLessThanOrEqualTo(String value) {
            addCriterion("respond_to_messages_id <=", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdLike(String value) {
            addCriterion("respond_to_messages_id like", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdNotLike(String value) {
            addCriterion("respond_to_messages_id not like", value, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIn(List<String> values) {
            addCriterion("respond_to_messages_id in", values, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdNotIn(List<String> values) {
            addCriterion("respond_to_messages_id not in", values, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdBetween(String value1, String value2) {
            addCriterion("respond_to_messages_id between", value1, value2, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdNotBetween(String value1, String value2) {
            addCriterion("respond_to_messages_id not between", value1, value2, "respondToMessagesId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdIsNull() {
            addCriterion("respond_to_messages_id_id is null");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdIsNotNull() {
            addCriterion("respond_to_messages_id_id is not null");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdEqualTo(String value) {
            addCriterion("respond_to_messages_id_id =", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdNotEqualTo(String value) {
            addCriterion("respond_to_messages_id_id <>", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdGreaterThan(String value) {
            addCriterion("respond_to_messages_id_id >", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdGreaterThanOrEqualTo(String value) {
            addCriterion("respond_to_messages_id_id >=", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdLessThan(String value) {
            addCriterion("respond_to_messages_id_id <", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdLessThanOrEqualTo(String value) {
            addCriterion("respond_to_messages_id_id <=", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdLike(String value) {
            addCriterion("respond_to_messages_id_id like", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdNotLike(String value) {
            addCriterion("respond_to_messages_id_id not like", value, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdIn(List<String> values) {
            addCriterion("respond_to_messages_id_id in", values, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdNotIn(List<String> values) {
            addCriterion("respond_to_messages_id_id not in", values, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdBetween(String value1, String value2) {
            addCriterion("respond_to_messages_id_id between", value1, value2, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andRespondToMessagesIdIdNotBetween(String value1, String value2) {
            addCriterion("respond_to_messages_id_id not between", value1, value2, "respondToMessagesIdId");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(String value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(String value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(String value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(String value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLike(String value) {
            addCriterion("img_id like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotLike(String value) {
            addCriterion("img_id not like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<String> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<String> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andFabulousNumIsNull() {
            addCriterion("fabulous_num is null");
            return (Criteria) this;
        }

        public Criteria andFabulousNumIsNotNull() {
            addCriterion("fabulous_num is not null");
            return (Criteria) this;
        }

        public Criteria andFabulousNumEqualTo(Integer value) {
            addCriterion("fabulous_num =", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumNotEqualTo(Integer value) {
            addCriterion("fabulous_num <>", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumGreaterThan(Integer value) {
            addCriterion("fabulous_num >", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fabulous_num >=", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumLessThan(Integer value) {
            addCriterion("fabulous_num <", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumLessThanOrEqualTo(Integer value) {
            addCriterion("fabulous_num <=", value, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumIn(List<Integer> values) {
            addCriterion("fabulous_num in", values, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumNotIn(List<Integer> values) {
            addCriterion("fabulous_num not in", values, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumBetween(Integer value1, Integer value2) {
            addCriterion("fabulous_num between", value1, value2, "fabulousNum");
            return (Criteria) this;
        }

        public Criteria andFabulousNumNotBetween(Integer value1, Integer value2) {
            addCriterion("fabulous_num not between", value1, value2, "fabulousNum");
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

        public Criteria andTimeBeiYiIsNull() {
            addCriterion("time_bei_yi is null");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiIsNotNull() {
            addCriterion("time_bei_yi is not null");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiEqualTo(Date value) {
            addCriterion("time_bei_yi =", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiNotEqualTo(Date value) {
            addCriterion("time_bei_yi <>", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiGreaterThan(Date value) {
            addCriterion("time_bei_yi >", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiGreaterThanOrEqualTo(Date value) {
            addCriterion("time_bei_yi >=", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiLessThan(Date value) {
            addCriterion("time_bei_yi <", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiLessThanOrEqualTo(Date value) {
            addCriterion("time_bei_yi <=", value, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiIn(List<Date> values) {
            addCriterion("time_bei_yi in", values, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiNotIn(List<Date> values) {
            addCriterion("time_bei_yi not in", values, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiBetween(Date value1, Date value2) {
            addCriterion("time_bei_yi between", value1, value2, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiYiNotBetween(Date value1, Date value2) {
            addCriterion("time_bei_yi not between", value1, value2, "timeBeiYi");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErIsNull() {
            addCriterion("time_bei_er is null");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErIsNotNull() {
            addCriterion("time_bei_er is not null");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErEqualTo(Date value) {
            addCriterion("time_bei_er =", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErNotEqualTo(Date value) {
            addCriterion("time_bei_er <>", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErGreaterThan(Date value) {
            addCriterion("time_bei_er >", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErGreaterThanOrEqualTo(Date value) {
            addCriterion("time_bei_er >=", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErLessThan(Date value) {
            addCriterion("time_bei_er <", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErLessThanOrEqualTo(Date value) {
            addCriterion("time_bei_er <=", value, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErIn(List<Date> values) {
            addCriterion("time_bei_er in", values, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErNotIn(List<Date> values) {
            addCriterion("time_bei_er not in", values, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErBetween(Date value1, Date value2) {
            addCriterion("time_bei_er between", value1, value2, "timeBeiEr");
            return (Criteria) this;
        }

        public Criteria andTimeBeiErNotBetween(Date value1, Date value2) {
            addCriterion("time_bei_er not between", value1, value2, "timeBeiEr");
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