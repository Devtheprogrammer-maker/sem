# USE CASE: 4 Produce a Report on the Salary of Employees of a Given Role 

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want *to produce a report on the salary of employees of a given role* so that *I can support financial reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the role.  Database contains current employee salary data.

### Success End Condition

A report is available for HR to provide to finance.

### Failed End Condition

No report is produced.

### Primary Actor

HR Advisor.

### Trigger

A request for finance information is sent to HR.

## MAIN SUCCESS SCENARIO

1. Finance request salary information for a given role.
2. HR advisor captures name of the role to get salary information for.
3. HR advisor extracts current salary information of all employees of the given role.
4. HR advisor provides report to finance.

## EXTENSIONS

3. **Role does not exist**:
    1. HR advisor informs finance no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0


### Outline:
1. Goal in Context - we will use our user story.
2. Scope - is discussed more in the Unit notes. Scoping is an important consideration in any work you do.
3. Level - what level is the use case targeted at. This is discussed further in the Unit notes.
4. Preconditions - what do we expect is true before the use case is executed.
5. Success Condition - what will happen on completion of the goal.
6. Failed Condition - what will happen on failure of the goal.
7. Primary Actor - the main actor of the use case.
8. Trigger - how is the use case started.
9. Main Success Scenario - what are the steps leading to success.
10. Extensions - what might happen at a given step to stop the use case.
11. Sub-variations - any other branches that a step can take?
12. Schedule - when does the use case need to be delivered.