package com.example.hirein.UI

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.hirein.data.db.entity.Company
import com.example.hirein.data.model.JobPostData
import kotlin.math.max
import kotlin.math.min
import kotlin.properties.Delegates
@BindingAdapter("minSalary", "maxSalary")
fun TextView.setSalaryRange(minSalary:Int, maxSalary:Int){
    var salaryString ="Rs "
    if(maxSalary == minSalary && minSalary < 100000){
        salaryString+= "$minSalary"
    }
    else if(minSalary >= 100000){
        var temp = minSalary/100000
        salaryString += "$temp  -"

        temp = maxSalary/100000
        salaryString += "$temp LPA"
    }else{
        salaryString += "$minSalary -"
        if(maxSalary > 100000){
            salaryString = " $maxSalary/100000 "
        }
        else{
            salaryString+= "$maxSalary "
        }
    }
    text = salaryString

}

@BindingAdapter("requirements")
fun TextView.setRequirements(requirements: List<String>){
    var requirement =""
    requirements.forEach {
        if( !it.contains("\n"))
            requirement+= "-$it\n"
        else
            requirement+= "-$it"

    }
    text = requirement
}
@BindingAdapter("skills")
fun TextView.setSkills(skills: List<String>){
    var skill =""

    skills.forEach {
        if(it!= skills[skills.lastIndex])
            skill+= "$it , "
        else
            skill+= "$it."
    }
    text = skill
}
@BindingAdapter("companyDetails")
fun TextView.setCompanyDetails(company:Company){
    text ="${company.minEmployeeCount} - ${company.maxEmployeeCount} Employees "

}
@BindingAdapter("role","companyName")
fun TextView.setRoleDetalis(role :String, companyName:String){
    if(role.isEmpty()) {
        when {
            companyName.isEmpty() -> text = " "
            else -> text = "$companyName Employee"
        }
    }
    else
    {
        when {
            companyName.isEmpty() -> text = "$role "
            else -> text = "$role @ $companyName"
        }
    }


}