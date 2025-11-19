package com.example.javamavenjunithelloworld;

/**
 * PURPOSE: This class is intentionally crafted to FAIL SonarQube's Quality Gate for NEW CODE.
 * Additions here are untested, duplicated, complex, and include issues Sonar flags.
 * DO NOT SHIP. Remove after validating PR quality gate blocking.
 */
public class QualityGateBreakerFail {

    // Hardcoded fake secret to trigger a security hotspot / code smell.
    private static final String AWS_SECRET_KEY = "AKIA_FAKE_FAKE_FAKE_SECRET_123456"; // Non-production
    private static final String PASSWORD = "P@ssw0rd!"; // Hardcoded password

    // Unused field (code smell)
    private int unusedCounter = 42;

    // Duplicate logic block #1
    public int duplicateCalcA(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    sum += i * j;
                } else if (i % 5 == 0) {
                    sum -= j;
                } else if (j % 7 == 0) {
                    sum += i;
                } else if (i == j) {
                    sum++;
                } else if (i + j == n) {
                    sum += n;
                } else if (i - j > 10) {
                    sum -= 2;
                } else if (j - i > 10) {
                    sum += 2;
                } else if ((i * j) % 11 == 0) {
                    sum += 11;
                } else {
                    sum += 1;
                }
            }
        }
        return riskyDivide(sum, n); // potential division by zero when n == 0
    }

    // Duplicate logic block #2 (intentional duplication)
    public int duplicateCalcB(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    sum += i * j;
                } else if (i % 5 == 0) {
                    sum -= j;
                } else if (j % 7 == 0) {
                    sum += i;
                } else if (i == j) {
                    sum++;
                } else if (i + j == n) {
                    sum += n;
                } else if (i - j > 10) {
                    sum -= 2;
                } else if (j - i > 10) {
                    sum += 2;
                } else if ((i * j) % 11 == 0) {
                    sum += 11;
                } else {
                    sum += 1;
                }
            }
        }
        return riskyDivide(sum, n); // duplicated risky pattern
    }

    // High cognitive complexity method with nested branches.
    public String complexFlow(int a, int b, boolean flag, boolean holiday, int hour) {
        StringBuilder sb = new StringBuilder();
        if (a > 10) {
            if (b > 20) {
                if (flag) {
                    if (holiday) {
                        if (hour > 20) {
                            sb.append("LateParty");
                        } else {
                            sb.append("FunDay");
                        }
                    } else {
                        sb.append("WorkHard");
                    }
                } else {
                    sb.append("Neutral");
                }
            } else if (b > 5) {
                if (flag && holiday) {
                    sb.append("MiniBreak");
                } else if (flag) {
                    sb.append("Focus");
                } else if (holiday) {
                    sb.append("Chill");
                } else {
                    sb.append("Grind");
                }
            } else {
                sb.append("LowB");
            }
        } else if (a > 0) {
            if (b < 0) {
                sb.append("NegativeB");
            } else {
                sb.append("SmallA");
            }
        } else if (a == 0 && b == 0 && flag && holiday && hour == 0) {
            sb.append("EdgeCase"); // rare path
        } else {
            sb.append("Default");
        }
        try {
            // empty catch block -> code smell
            Integer.parseInt("notNumber");
        } catch (NumberFormatException ex) {
            // intentionally ignored
        }
        return sb.toString();
    }

    // Bug-prone helper: division by n without validation; returns null in one branch (reliability issue)
    private Integer riskyDivide(int value, int n) {
        if (n < 0) {
            return null; // returning null instead of throwing -> potential NPE for callers
        }
        return value / n; // division by zero risk
    }

    // Unused public API (code smell) with duplicated logic again
    public int yetAnotherDuplicate(int n) {
        return duplicateCalcA(n) + duplicateCalcB(n);
    }
}
