<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Administração</title>
</head>
<body>
    <h1>Administração</h1>

    <h2>Adicionar Convênio</h2>
    <form:form action="${pageContext.request.contextPath}/admin/convenios/add" modelAttribute="convenioCreateRequest" method="post">
        <label for="nome">Nome:</label>
        <form:input path="nome" id="nome" required="true"/>
        <!-- Outros campos -->
        <button type="submit">Adicionar Convênio</button>
    </form:form>

    <h2>Adicionar Especialidade</h2>
    <form:form action="${pageContext.request.contextPath}/admin/especialidades/add" modelAttribute="especialidadeCreateRequest" method="post">
        <label for="nome">Nome:</label>
        <form:input path="nome" id="nome" required="true"/>
        <!-- Outros campos -->
        <button type="submit">Adicionar Especialidade</button>
    </form:form>

    <h2>Adicionar Funcionário</h2>
    <form:form action="${pageContext.request.contextPath}/admin/funcionarios/add" modelAttribute="funcionarioCreateRequest" method="post">
        <label for="nomeCompleto">Nome Completo:</label>
        <form:input path="nomeCompleto" id="nomeCompleto" required="true"/>
        <!-- Outros campos -->
        <button type="submit">Adicionar Funcionário</button>
    </form:form>

    <h2>Adicionar Médico</h2>
    <form:form action="${pageContext.request.contextPath}/admin/medicos/add" modelAttribute="medicoCreateRequest" method="post">
        <label for="nome">Nome:</label>
        <form:input path="nome" id="nome" required="true"/>
        <!-- Outros campos -->
        <button type="submit">Adicionar Médico</button>
    </form:form>

    <h2>Adicionar Usuário</h2>
    <form:form action="${pageContext.request.contextPath}/admin/usuarios/add" modelAttribute="usuarioCreateRequest" method="post">
        <label for="nome">Nome:</label>
        <form:input path="nome" id="nome" required="true"/>
        <!-- Outros campos -->
        <button type="submit">Adicionar Usuário</button>
    </form:form>

    <h2>Lista de Convênios</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <!-- Outros campos -->
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="convenio" items="${convenios}">
                <tr>
                    <td>${convenio.id}</td>
                    <td>${convenio.nome}</td>
                    <!-- Outros campos -->
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/convenios/edit/${convenio.id}">Editar</a>
                        <a href="${pageContext.request.contextPath}/admin/convenios/delete/${convenio.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Tabelas similares para Especialidades, Funcionários, Médicos, Usuários -->
</body>
</html>