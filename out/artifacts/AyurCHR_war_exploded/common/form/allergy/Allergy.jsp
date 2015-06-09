<div id="dialogOne" data-dojo-type="dijit.Dialog" title="Add/Edit Allergy" style="width:440px;">

    <div data-dojo-type="dijit.form.Form" id="AllergyForm" data-dojo-id="AllergyForm"
         encType="multipart/form-data" action="common/form/SaveForm.jsp" method="">
        <script type="text/javascript">
            var prg_reset = 0;
        </script>

        <script type="dojo/method" data-dojo-event="onSubmit">
            if(this.validate())
            {
            if(confirm('Are you sure you want to update the Allergy?'))
            {
            postForm(this.id);
            dijit.byId("AllergyForm").reset();
            dijit.byId("dialogOne").hide();
            }
            return false;
            }else{
            alert('Form contains invalid Allergy data. Please correct first');
            return false;
            }
            return true;
        </script>

        <input type='hidden' id='AllergyUserId' name='UserId' value=''/>
        <input type='hidden' name='CLASS' value='fv.ayurchr.dbobjects.hibernate.Allergy'/>
        <input type='hidden' name='ENTITY' value='ALLERGY'/>

        <div style="float:left">
            <label for='AllergyType'>Allergy Type:</label><br/>
            <input name="AllergyType" id='AllergyType' type='text' data-dojo-type="dijit.form.TextBox"
                   style="width: 200px;"/>
        </div>

        <div style="float:right">
            <label for='Severity'>Severity:</label><br/>
            <input name="Severity" id='Severity' type='text' data-dojo-type="dijit.form.TextBox" style="width: 200px;"/>
        </div>
        <br/><br/><br/>

        <div style="float:left">
            <label for='StartDate'>Start Date:</label><br/>
            <input name="StartDate" id='StartDate' type='text' data-dojo-type="dijit.form.DateTextBox"
                   style="width: 200px;"/>
        </div>
        <div style="float:right">
            <label for='EndDate'>End Date:</label><br/>
            <input name="EndDate" id='EndDate' type='text' data-dojo-type="dijit.form.DateTextBox"
                   style="width: 200px;"/>
        </div>
        <br/> <br/>

        <div style="float:left">
            <label for='Reaction'>Reaction:</label><br/>
            <input name="Reaction" id='Reaction' type='text' data-dojo-type="dijit.form.TextBox" style="width: 200px;"/>
        </div>

        <div style="float:right">
            <label for='Medication'>Medication:</label><br/>
            <input name="Medication" id='Medication' type='text' data-dojo-type="dijit.form.TextBox"
                   style="width: 200px;"/>
        </div>
        <br/> <br/><br/>

        <div style="float:left">
            <label for='Comments'>Other Comments:</label><br/>
            <textarea name="Comments" id="Comments" name="OtherComments" data-dojo-type="dijit.form.Textarea"
                      style="width:420px;"></textarea>
        </div>
        <button data-dojo-type="dijit.form.Button" type="submit" name="submitButton" value="Submit">Submit</button>
        <button data-dojo-type="dijit.form.Button" type="reset">Reset</button>
    </div>
</div>