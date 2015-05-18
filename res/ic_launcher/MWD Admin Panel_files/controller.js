/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';
/* Controllers */


function loginFormCtrl($scope, $http, $location){
    $scope.formData = {};
    $scope.submit = function() {
        $('.message').hide();
        $('#logging').show();
        $http({
            url: 'http://localhost:8080/MWDWebService/api/login',
            method: "POST",
            data: this.formData,
            headers: {
                'Content-Type': 'application/json'
            }
        }).success(function (data, status, headers, config) {
            $('#logging').hide();
            if(data.status == '400'){
                $('#error').html(data.message).show();
            }else{
                $location.path('/home');
            }
        }).error(function (data, status, headers, config) {
            $('#logging').hide();
            $('#error').html("Error logging in...Please check your network.").show();
        });
    };

}

function homeCtrl($scope, $http, $location){
    $('.actionbar').hide();
    $('.option a').click(function(){
        $('.option').removeClass('active');
        if($(this).attr('id') == 'option_cat'){
            $(this).addClass('active');
            $('ab_category').show();
        }
    });
}