Javadoc generated. Check 02javadoc.err file for full details on the auctual* warnings considered below:

----------------------------------- Section 1: Warnings Table -----------------------------------
--------------------------------------------------------------------------------------------------------------
| File                                               | Number of Warnings   | Warning Reason                 |
--------------------------------------------------------------------------------------------------------------
| Move.java                                          | 1                    | Line 27: no main description   |
| Move.java                                          | 1                    | Line 35: no main description   |
| OthelloRandomProbability.java                      | 1                    | Line 117: no @param for numgames |
| OthelloRandomProbability.java                      | 1                    | Line 159: no main description  |
| OthelloRandomProbability.java                      | 1                    | Line 175: no @param for args   |
| Player.java                                        | 1                    | Line 16: no description for @param |
| Player.java                                        | 1                    | Line 17: no description for @param |
| Player.java                                        | 1                    | Line 25: no @return            |
| PlayerHuman.java                                   | 1                    | Line 24: no description for @param |
| PlayerHuman.java                                   | 1                    | Line 25: no description for @param |
--------------------------------------------------------------------------------------------------------------
Total *"actual" Warnings for dionis17: 10
--------------------------------------------------------------------------------------------------------------

----------------------------------- Section 2: Results Table ------------------------------------
+------------------------------------------+-------------------------+-----------------------------------------------+
| Criteria                                 | Score                   | Comments                                      |
+------------------------------------------+-------------------------+-----------------------------------------------+
| All public methods have Javadoc          |    0.50 / 1              | Ensure every public method and constructor    |
|                                          |                         | is documented with proper Javadoc formatting. |
+------------------------------------------+-------------------------+-----------------------------------------------+
| Documentation is clear, concise, and     |    1.00 / 1              | Check for readability, conciseness, and       |
| simple                                   |                         | alignment with the method's functionality.    |
+------------------------------------------+-------------------------+-----------------------------------------------+
| Important/complex private methods have   |    1.00 / 1              | Verify key private methods (e.g., complex     |
| Javadoc                                  |                         | logic) are adequately documented. Avoid       |
|                                          |                         | over-documenting trivial private methods.     |
+------------------------------------------+-------------------------+-----------------------------------------------+
| **Total Score**                          |    2.50 / 3              | Check 02javadoc.out for more details.         |
+------------------------------------------+-------------------------+-----------------------------------------------+


---------------------------------- Section 3: General Details on Marking Criteria ----------------------------------

Criteria for warnings counted as "actual" warnings in Javadoc:

0. Mark for the criteria: "All public methods have Javadoc" in the marking scheme = 1 - (0.05 * each "actual" warning).
    e.g. if you got 5 "actual" warnings, then, the mark for criteria 1 will be 1 - (0.05 * 5) = 0.75.
1. Not coming from starter files (.java), except for specified files in criteria 2.
   Any files (.java) that you had created (fresh) were also considered for Javadoc.
2. Warnings in Move.java and PlayerHuman.java were considered, as we clearly mentioned at the top of the file in the starter code that "Document this class...".
   By "Document", we expect you to do both Javadoc and general code documentation for complex parts. (*this cannot be a reason for remark).
4. Warnings related to "protected" member reasons were NOT counted.
5. Warnings related to "default constructor" reasons were NOT counted.

Overall, we were very lenient with the Javadoc marking criteria.

-- "At the end of the day, our goal is to help you become not just a programmer, but a great one.
-- A great software engineer always documents their code thoughtfully and effectively, making it easier for others to understand and build upon their work."

--------------------------------------------------------------------------------------------------------------

