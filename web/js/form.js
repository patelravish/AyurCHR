dojo.provide("fv.common.form");

fv.common.form.onSubmitForm = function(formobject) {

    if (formobject.validate()) {
        if (confirm('Form is valid, press OK to submit')) {
            submitf.value = 'true';
            return true;
        }
        else return false;
    } else {
        alert('Form contains invalid data. Please correct first');
        return false;
    }
    return true;
};

var postForm = function(formname) {
    var xhrArgs =
    {
        form: formname,
        handleAs: "text",
        load: function(data) {
        },
        error: function(error) {
        }
    }
    var deferred = dojo.xhrPost(xhrArgs);
};