package top.whattowatch.wtw.po;

import java.util.ArrayList;
import java.util.List;

public class ViewTypeStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewTypeStatisticsExample() {
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

        public Criteria andVtsIdIsNull() {
            addCriterion("vts_id is null");
            return (Criteria) this;
        }

        public Criteria andVtsIdIsNotNull() {
            addCriterion("vts_id is not null");
            return (Criteria) this;
        }

        public Criteria andVtsIdEqualTo(Integer value) {
            addCriterion("vts_id =", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdNotEqualTo(Integer value) {
            addCriterion("vts_id <>", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdGreaterThan(Integer value) {
            addCriterion("vts_id >", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vts_id >=", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdLessThan(Integer value) {
            addCriterion("vts_id <", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdLessThanOrEqualTo(Integer value) {
            addCriterion("vts_id <=", value, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdIn(List<Integer> values) {
            addCriterion("vts_id in", values, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdNotIn(List<Integer> values) {
            addCriterion("vts_id not in", values, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdBetween(Integer value1, Integer value2) {
            addCriterion("vts_id between", value1, value2, "vtsId");
            return (Criteria) this;
        }

        public Criteria andVtsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vts_id not between", value1, value2, "vtsId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMTypeIsNull() {
            addCriterion("m_type is null");
            return (Criteria) this;
        }

        public Criteria andMTypeIsNotNull() {
            addCriterion("m_type is not null");
            return (Criteria) this;
        }

        public Criteria andMTypeEqualTo(String value) {
            addCriterion("m_type =", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotEqualTo(String value) {
            addCriterion("m_type <>", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeGreaterThan(String value) {
            addCriterion("m_type >", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeGreaterThanOrEqualTo(String value) {
            addCriterion("m_type >=", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLessThan(String value) {
            addCriterion("m_type <", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLessThanOrEqualTo(String value) {
            addCriterion("m_type <=", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLike(String value) {
            addCriterion("m_type like", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotLike(String value) {
            addCriterion("m_type not like", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeIn(List<String> values) {
            addCriterion("m_type in", values, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotIn(List<String> values) {
            addCriterion("m_type not in", values, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeBetween(String value1, String value2) {
            addCriterion("m_type between", value1, value2, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotBetween(String value1, String value2) {
            addCriterion("m_type not between", value1, value2, "mType");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }
    }

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