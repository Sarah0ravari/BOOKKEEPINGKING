package com.example.bookkeepingking;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

import LocalDatabase.DataBaseHelper;
import LocalDatabase.Employee;

public class EditEmployeeFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_edit_employee, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //populate the edit text boxes
        //requires employee id number
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        Employee employee = dataBaseHelper.getEmployee(3);
        EditText textBox = (EditText) getView().findViewById(R.id.editTextFirstName);
        textBox.setText(employee.getF_name());
        textBox = (EditText) getView().findViewById(R.id.editTextMiddleName);
        textBox.setText(employee.getM_name());
        textBox = (EditText) getView().findViewById(R.id.editTextLastName);
        textBox.setText(employee.getL_name());
        textBox = (EditText) getView().findViewById(R.id.editTextSsn);
        textBox.setText(employee.getSsn());
        textBox = (EditText) getView().findViewById(R.id.editTextPhnnumber);
        textBox.setText(employee.getPhone());
        textBox = (EditText) getView().findViewById(R.id.editTextAddress);
        textBox.setText(employee.getAddress());
        textBox = (EditText) getView().findViewById(R.id.editTextCity);
        textBox.setText(employee.getCity());
        textBox = (EditText) getView().findViewById(R.id.editTextState);
        textBox.setText(employee.getState());
        textBox = (EditText) getView().findViewById(R.id.editTextZip);
        textBox.setText(employee.getZip());
        textBox = (EditText) getView().findViewById(R.id.editTextAllow);
        textBox.setText(String.valueOf(employee.getAllowances()));
            //create database object
        //DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
            //create list of all employees in database
        //List<Employee> list = dataBaseHelper.getAllEmployee();
            //create edit text object to set new value to
        //EditText editTextFirstName = (EditText) getView().findViewById(R.id.editTextFirstName);
            //set edit text box to first employee first name
        //editTextFirstName.setText(list.get(0).getF_name());


        view.findViewById(R.id.buttonSavePayroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditEmployeeFragment.this).
                        navigate(R.id.action_editEmployeeFragment_to_HomeFragment);
            }
        });
        view.findViewById(R.id.buttonCancelEmpEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditEmployeeFragment.this).
                        navigate(R.id.action_editEmployeeFragment_to_HomeFragment);
            }
        });
    }
}
