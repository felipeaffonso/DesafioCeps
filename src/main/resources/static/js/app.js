angular.module('enderecos', ['ngResource', 'ngMessages'])
	.controller('EnderecoController', function($scope, Endereco, Cep) {
		
		$scope.enderecos = [];
		$scope.endereco = {};
		$scope.mensagemErroCep = null;
		
		
		$scope.buscaTodosEnderecos = function() {
			Endereco.query({}, function(enderecos) {
				$scope.enderecos = enderecos;
			});
		};
		
		$scope.buscaCep = function() {
			if($scope.endereco.cep) {
				Cep.get({numero: $scope.endereco.cep}, function(cep) {
					$scope.endereco.cep = cep.cep;
					$scope.endereco.rua = cep.rua;
					$scope.endereco.bairro = cep.bairro;
					$scope.endereco.cidade = cep.cidade;
					$scope.endereco.estado = cep.estado;
				}, function(error) {
					alert(error.data.message);
					$scope.endereco.rua = '';
					$scope.endereco.bairro = '';
					$scope.endereco.cidade = '';
					$scope.endereco.estado = '';
				});
			}else {
				alert('Por favor, digite o CEP');
			}
		};
		
		$scope.selecionaEndereco = function($index) {
			angular.copy($scope.enderecos[$index], $scope.endereco);
		}
		
		$scope.salvaEndereco = function() {
			if($scope.endereco.id) {
				Endereco.update($scope.endereco, function(endereco) {
					$scope.buscaTodosEnderecos();
					$scope.endereco = {};
					alert("Endereço ID: " + endereco.id + " atualizado com sucesso.");
				}, function(errors){
					if(errors) {
						alert(erros.data.message);
					}
				});
			}else {
				Endereco.save($scope.endereco, function(endereco) {
					$scope.buscaTodosEnderecos();
					$scope.endereco = {};
					alert("Endereço ID: " + endereco.id + " criado com sucesso.");
				}, function(errors) {
					if(errors) {
						alert(errors.data.message);
					}
				});
			}
		};
		
		$scope.novoEndereco = function() {
			$scope.endereco = {};
		}
		
		$scope.deletaEndereco = function() {
			Endereco.remove({id: $scope.endereco.id}, function(data) {
				alert("Endereço ID: " + $scope.endereco.id + " excluído com sucesso!")
				$scope.endereco = {};
				$scope.buscaTodosEnderecos();
			}, function(errors) {
				if(errors){
					alert(erros.data.message);
				}
			});
			
		}
		
		
		
		$scope.buscaTodosEnderecos();
		
	})
	.factory('Endereco', function($resource) {
		return $resource('/endereco/:id', null, 
		{
	        'update': { method:'PUT' }
	    });
	})
	.factory('Cep', function($resource) {
		return $resource('/cep/:numero');
	});
