<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>스낵 투표 통계</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        .snack-statistics {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .statistics-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .statistics-table th, .statistics-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .statistics-table th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<c:forEach items="${statistics}" var="entry">
    <div class="snack-statistics">
        <h2>${entry.key.name} 투표 통계</h2>
        <img src="${entry.key.imageUrl}" alt="${entry.key.name}" width="200"/>

        <h3>상세 투표 정보</h3>
        <table class="statistics-table">
            <thead>
            <tr>
                <th>나이</th>
                <th>혈액형</th>
                <th>성별</th>
                <th>투표 수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${entry.value.snackAVotes}" var="voteMap">
                <c:forEach items="${voteMap}" var="vote">
                    <tr>
                        <td>${vote.key.age.ageName}</td>
                        <td>${vote.key.bloodType}</td>
                        <td>${vote.key.gender}</td>
                        <td>${vote.value}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>

        <!-- 총 투표 수 계산 -->
        <c:set var="totalVotes" value="0" />
        <c:forEach items="${entry.value.snackAVotes}" var="voteMap">
            <c:forEach items="${voteMap}" var="vote">
                <c:set var="totalVotes" value="${totalVotes + vote.value}" />
            </c:forEach>
        </c:forEach>
        <p>총 투표 수: ${totalVotes}</p>

        <!-- 차트 -->
        <canvas id="voteChart${entry.key.id}" width="400" height="200"></canvas>

        <script>
            var ctx = document.getElementById('voteChart${entry.key.id}').getContext('2d');
            var chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: [
                        <c:forEach items="${entry.value.snackAVotes}" var="voteMap">
                        <c:forEach items="${voteMap}" var="vote">
                        '${vote.key.age.ageName} ${vote.key.bloodType}형 ${vote.key.gender}',
                        </c:forEach>
                        </c:forEach>
                    ],
                    datasets: [{
                        label: '투표 수',
                        data: [
                            <c:forEach items="${entry.value.snackAVotes}" var="voteMap">
                            <c:forEach items="${voteMap}" var="vote">
                            ${vote.value},
                            </c:forEach>
                            </c:forEach>
                        ],
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </div>
</c:forEach>

</body>
</html>