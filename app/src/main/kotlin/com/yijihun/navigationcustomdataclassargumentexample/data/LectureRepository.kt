package com.yijihun.navigationcustomdataclassargumentexample.data

import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student
import javax.inject.Inject

interface LectureRepository {
    fun getLectureList(): List<Lecture>
    fun getStudentList(): List<Student>
    fun getStudentGradeList(): List<Int>
}

class LectureRepositoryImpl @Inject constructor() : LectureRepository {
    override fun getLectureList(): List<Lecture> {
        return mockLectureList
    }

    override fun getStudentList(): List<Student> {
        return mockStudentList
    }

    override fun getStudentGradeList(): List<Int> {
        return mockStudentGradeList
    }

    companion object {
        val mockLectureList = listOf(
            Lecture(1, "컴퓨터개론", "김철수 교수"),
            Lecture(2, "자료구조", "이영희 교수"),
            Lecture(3, "데이터베이스", "박민수 교수"),
            Lecture(4, "인공지능", "정미경 교수"),
            Lecture(5, "웹개발", "홍길동 교수"),
            Lecture(6, "컴퓨터구조", "오세훈 교수"),
            Lecture(7, "운영체제", "나영석 교수"),
            Lecture(8, "앱 개발", "장민호 교수"),
        )

        val mockStudentList = listOf(
            Student(1, "강지원", 1),
            Student(2, "이민준", 2),
            Student(3, "박서연", 1),
            Student(4, "김도현", 3),
            Student(5, "최예은", 2),
            Student(6, "정우진", 1),
            Student(7, "송하은", 3),
            Student(8, "윤준서", 2),
            Student(9, "임수빈", 1),
            Student(10, "한지민", 3),
        )

        val mockStudentGradeList = listOf(
            Student(1, "강지원", 1),
            Student(2, "이민준", 2),
            Student(3, "박서연", 1),
            Student(4, "김도현", 3),
            Student(5, "최예은", 2),
            Student(6, "정우진", 1),
            Student(7, "송하은", 3),
            Student(8, "윤준서", 2),
            Student(9, "임수빈", 1),
            Student(10, "한지민", 3),
        ).map { student -> student.grade }
    }
}
