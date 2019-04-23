package com.neverend.blog.entity;

import java.util.ArrayList;
import java.util.List;

public class LanMuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LanMuExample() {
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

        public Criteria andYiJiLanMuIdIsNull() {
            addCriterion("yi_ji_lan_mu_id is null");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdIsNotNull() {
            addCriterion("yi_ji_lan_mu_id is not null");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdEqualTo(String value) {
            addCriterion("yi_ji_lan_mu_id =", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdNotEqualTo(String value) {
            addCriterion("yi_ji_lan_mu_id <>", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdGreaterThan(String value) {
            addCriterion("yi_ji_lan_mu_id >", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdGreaterThanOrEqualTo(String value) {
            addCriterion("yi_ji_lan_mu_id >=", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdLessThan(String value) {
            addCriterion("yi_ji_lan_mu_id <", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdLessThanOrEqualTo(String value) {
            addCriterion("yi_ji_lan_mu_id <=", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdLike(String value) {
            addCriterion("yi_ji_lan_mu_id like", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdNotLike(String value) {
            addCriterion("yi_ji_lan_mu_id not like", value, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdIn(List<String> values) {
            addCriterion("yi_ji_lan_mu_id in", values, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdNotIn(List<String> values) {
            addCriterion("yi_ji_lan_mu_id not in", values, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdBetween(String value1, String value2) {
            addCriterion("yi_ji_lan_mu_id between", value1, value2, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andYiJiLanMuIdNotBetween(String value1, String value2) {
            addCriterion("yi_ji_lan_mu_id not between", value1, value2, "yiJiLanMuId");
            return (Criteria) this;
        }

        public Criteria andLanMuNameIsNull() {
            addCriterion("lan_mu_name is null");
            return (Criteria) this;
        }

        public Criteria andLanMuNameIsNotNull() {
            addCriterion("lan_mu_name is not null");
            return (Criteria) this;
        }

        public Criteria andLanMuNameEqualTo(String value) {
            addCriterion("lan_mu_name =", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameNotEqualTo(String value) {
            addCriterion("lan_mu_name <>", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameGreaterThan(String value) {
            addCriterion("lan_mu_name >", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameGreaterThanOrEqualTo(String value) {
            addCriterion("lan_mu_name >=", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameLessThan(String value) {
            addCriterion("lan_mu_name <", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameLessThanOrEqualTo(String value) {
            addCriterion("lan_mu_name <=", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameLike(String value) {
            addCriterion("lan_mu_name like", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameNotLike(String value) {
            addCriterion("lan_mu_name not like", value, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameIn(List<String> values) {
            addCriterion("lan_mu_name in", values, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameNotIn(List<String> values) {
            addCriterion("lan_mu_name not in", values, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameBetween(String value1, String value2) {
            addCriterion("lan_mu_name between", value1, value2, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andLanMuNameNotBetween(String value1, String value2) {
            addCriterion("lan_mu_name not between", value1, value2, "lanMuName");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdIsNull() {
            addCriterion("super_lan_mu_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdIsNotNull() {
            addCriterion("super_lan_mu_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdEqualTo(String value) {
            addCriterion("super_lan_mu_id =", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdNotEqualTo(String value) {
            addCriterion("super_lan_mu_id <>", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdGreaterThan(String value) {
            addCriterion("super_lan_mu_id >", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdGreaterThanOrEqualTo(String value) {
            addCriterion("super_lan_mu_id >=", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdLessThan(String value) {
            addCriterion("super_lan_mu_id <", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdLessThanOrEqualTo(String value) {
            addCriterion("super_lan_mu_id <=", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdLike(String value) {
            addCriterion("super_lan_mu_id like", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdNotLike(String value) {
            addCriterion("super_lan_mu_id not like", value, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdIn(List<String> values) {
            addCriterion("super_lan_mu_id in", values, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdNotIn(List<String> values) {
            addCriterion("super_lan_mu_id not in", values, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdBetween(String value1, String value2) {
            addCriterion("super_lan_mu_id between", value1, value2, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andSuperLanMuIdNotBetween(String value1, String value2) {
            addCriterion("super_lan_mu_id not between", value1, value2, "superLanMuId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdIsNull() {
            addCriterion("role_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdIsNotNull() {
            addCriterion("role_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdEqualTo(String value) {
            addCriterion("role_permission_id =", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotEqualTo(String value) {
            addCriterion("role_permission_id <>", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdGreaterThan(String value) {
            addCriterion("role_permission_id >", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_permission_id >=", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdLessThan(String value) {
            addCriterion("role_permission_id <", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdLessThanOrEqualTo(String value) {
            addCriterion("role_permission_id <=", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdLike(String value) {
            addCriterion("role_permission_id like", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotLike(String value) {
            addCriterion("role_permission_id not like", value, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdIn(List<String> values) {
            addCriterion("role_permission_id in", values, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotIn(List<String> values) {
            addCriterion("role_permission_id not in", values, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdBetween(String value1, String value2) {
            addCriterion("role_permission_id between", value1, value2, "rolePermissionId");
            return (Criteria) this;
        }

        public Criteria andRolePermissionIdNotBetween(String value1, String value2) {
            addCriterion("role_permission_id not between", value1, value2, "rolePermissionId");
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