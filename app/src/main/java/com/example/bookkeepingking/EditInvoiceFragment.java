package com.example.bookkeepingking;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import LocalDatabase.DataBaseHelper;
import LocalDatabase.Employee;
import LocalDatabase.Invoice;

public class EditInvoiceFragment extends Fragment {
    boolean invoiceIsNew;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_edit_invoice, container, false);
        // Inflate the layout for this fragment
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //populate the edit text boxes
        //requires employee id number
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        Invoice invoice = dataBaseHelper.getInvoice(1);
        EditText textBox = (EditText) getView().findViewById(R.id.editTextInvoiceDate);
        textBox.setText(invoice.getI_date());
        textBox = (EditText) getView().findViewById(R.id.editTextInvoiceNum);
        textBox.setText(invoice.getInvoice_num());
        textBox = (EditText) getView().findViewById(R.id.editTextInvoiceTotal);
        textBox.setText(invoice.getAmount());
        //create database object
        //DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        //create list of all employees in database
        //List<Invoice> list = dataBaseHelper.getAllInvoice();
        //create edit text object to set new value to
        //EditText editTextFirstName = (EditText) getView().findViewById(R.id.editTextInvoiceDate);
        //set edit text box to first employee first name
        //editTextFirstName.setText(list.get(0).getI_date());

        view.findViewById(R.id.buttonCancelInvoiceEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditInvoiceFragment.this).
                        navigate(R.id.action_editInvoiceFragment_to_HomeFragment);
            }
        });
        view.findViewById(R.id.buttonSaveInvoiceEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EditInvoiceFragment.this).
                        navigate(R.id.action_editInvoiceFragment_to_HomeFragment);
            }
        });
        view.findViewById(R.id.buttonUploadInvoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in= new Intent(getActivity(), AddInvoice.class);
                startActivity(in);
            }
        });
    }
}