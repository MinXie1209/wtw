package top.whattowatch.wtw.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoricalRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoricalRecordsExample() {
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

        public Criteria andHrIdIsNull() {
            addCriterion("hr_id is null");
            return (Criteria) this;
        }

        public Criteria andHrIdIsNotNull() {
            addCriterion("hr_id is not null");
            return (Criteria) this;
        }

        public Criteria andHrIdEqualTo(Integer value) {
            addCriterion("hr_id =", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotEqualTo(Integer value) {
            addCriterion("hr_id <>", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThan(Integer value) {
            addCriterion("hr_id >", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hr_id >=", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThan(Integer value) {
            addCriterion("hr_id <", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThanOrEqualTo(Integer value) {
            addCriterion("hr_id <=", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdIn(List<Integer> values) {
            addCriterion("hr_id in", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotIn(List<Integer> values) {
            addCriterion("hr_id not in", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdBetween(Integer value1, Integer value2) {
            addCriterion("hr_id between", value1, value2, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hr_id not between", value1, value2, "hrId");
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

        public Criteria andMTitleIsNull() {
            addCriterion("m_title is null");
            return (Criteria) this;
        }

        public Criteria andMTitleIsNotNull() {
            addCriterion("m_title is not null");
            return (Criteria) this;
        }

        public Criteria andMTitleEqualTo(String value) {
            addCriterion("m_title =", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotEqualTo(String value) {
            addCriterion("m_title <>", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleGreaterThan(String value) {
            addCriterion("m_title >", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleGreaterThanOrEqualTo(String value) {
            addCriterion("m_title >=", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLessThan(String value) {
            addCriterion("m_title <", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLessThanOrEqualTo(String value) {
            addCriterion("m_title <=", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleLike(String value) {
            addCriterion("m_title like", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotLike(String value) {
            addCriterion("m_title not like", value, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleIn(List<String> values) {
            addCriterion("m_title in", values, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotIn(List<String> values) {
            addCriterion("m_title not in", values, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleBetween(String value1, String value2) {
            addCriterion("m_title between", value1, value2, "mTitle");
            return (Criteria) this;
        }

        public Criteria andMTitleNotBetween(String value1, String value2) {
            addCriterion("m_title not between", value1, value2, "mTitle");
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