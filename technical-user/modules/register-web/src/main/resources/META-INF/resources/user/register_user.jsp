<%@ include file="/init.jsp"%>

<portlet:resourceURL var="addUserURL" id="/save_user" />

<div class="container my-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card shadow-lg rounded-4">
				<div class="card-body p-4">
					<h4 class="card-title mb-4 text-center">
						<liferay-ui:message key="register.users"></liferay-ui:message>
					</h4>

					<form id="userForm" novalidate>
						<div class="mb-3">
							<label for="name" class="form-label"> 
								<liferay-ui:message key="full.name"></liferay-ui:message> 
							</label> 
							<input
								type="text" class="form-control" id="name" name="name" required
								placeholder="Ej. Andrés Tinoco" 
							/>
						</div>

						<div class="mb-3">
							<label for="email" class="form-label">
								<liferay-ui:message key="email"></liferay-ui:message>
							</label>
							<input type="email" class="form-control" id="email" name="email"
								required placeholder="Ej. andrestinoco@email.com" />
						</div>

						<button type="button" class="btn btn-primary w-100" id="saveUserButton">
							<liferay-ui:message key="save" />
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	Liferay.on('SPAReady', function () {
		initUserForm();
	});

	if (document.readyState === "complete") {
		initUserForm();
	} else {
		window.addEventListener("load", initUserForm);
	}

	function initUserForm() {
		const namespace = '<portlet:namespace />';
		const form = document.getElementById("userForm");
		const button = document.getElementById("saveUserButton");

		if (!button || !form) {
			return;
		}

		button.addEventListener("click", function () {
			const name = document.getElementById("name").value.trim();
			const email = document.getElementById("email").value.trim();

			if (!name || !email) {
				alert("Por favor completa todos los campos.");
				return;
			}

			const formData = new FormData();
			formData.append(namespace + "name", name);
			formData.append(namespace + "email", email);

			fetch("<%= addUserURL.toString() %>", {
				method: "POST",
				body: formData
			})
			.then(response => response.json())
			.then(data => {
				if (data.success) {
					form.reset();
					alert("Se registró correctamente el usuario");
				} else {
					alert("Error al registrar usuario: " + data.error);
				}
			})
			.catch(error => {
				console.error("Error en la petición:", error);
				alert("Ha ocurrido un error inesperado");
			});
		});
	}
</script>
