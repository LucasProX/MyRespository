package com.lucas;

import java.util.List;

public interface StudentMapper {
    List<Student> selectByGrade(String Grade);
}
