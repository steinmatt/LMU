function varargout = HouseGUI(varargin)
% HOUSEGUI MATLAB code for HouseGUI.fig
%      HOUSEGUI, by itself, creates a new HOUSEGUI or raises the existing
%      singleton*.
%
%      H = HOUSEGUI returns the handle to a new HOUSEGUI or the handle to
%      the existing singleton*.
%
%      HOUSEGUI('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in HOUSEGUI.M with the given input arguments.
%
%      HOUSEGUI('Property','Value',...) creates a new HOUSEGUI or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before HouseGUI_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to HouseGUI_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help HouseGUI

% Last Modified by GUIDE v2.5 07-May-2017 21:01:16

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @HouseGUI_OpeningFcn, ...
                   'gui_OutputFcn',  @HouseGUI_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end

% End initialization code - DO NOT EDIT


% --- Executes just before HouseGUI is made visible.
function HouseGUI_OpeningFcn(hObject, eventdata, handles, varargin)

% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to HouseGUI (see VARARGIN)

% Choose default command line output for HouseGUI
handles.output = hObject;
set(handles.BaseLEdit, 'string', '20');
set(handles.BaseWEdit, 'string', '30');
set(handles.WallHEdit, 'string', '15');
set(handles.RoofAEdit, 'string', '10');

handles.BaseW = str2double(get(handles.BaseWEdit, 'String'));
handles.BaseL = str2double(get(handles.BaseLEdit, 'String'));
handles.WallH = str2double(get(handles.WallHEdit, 'String'));
handles.RoofA = str2double(get(handles.RoofAEdit, 'String'));

% Update handles structure
guidata(hObject, handles);




% UIWAIT makes HouseGUI wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Executes during object creation, after setting all properties.
function axes1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to axes1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate axes1

% --- Executes during object creation, after setting all properties.
function axes2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to axes2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate axes2


% --- Outputs from this function are returned to the command line.
function varargout = HouseGUI_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


function BaseLEdit_Callback(hObject, eventdata, handles)
% hObject    handle to BaseLEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

handles.BaseL = str2double(get(handles.BaseLEdit, 'String'));

% Hints: get(hObject,'String') returns contents of BaseLEdit as text
%        str2double(get(hObject,'String')) returns contents of BaseLEdit as a double
guidata(hObject, handles);


% --- Executes during object creation, after setting all properties.
function BaseLEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to BaseLEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function BaseWEdit_Callback(hObject, eventdata, handles)
% hObject    handle to BaseWEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

handles.BaseW = str2double(get(handles.BaseWEdit, 'String'));

% Hints: get(hObject,'String') returns contents of BaseWEdit as text
%        str2double(get(hObject,'String')) returns contents of BaseWEdit as a double
guidata(hObject, handles);



% --- Executes during object creation, after setting all properties.
function BaseWEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to BaseWEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function WallHEdit_Callback(hObject, eventdata, handles)
% hObject    handle to WallHEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

handles.WallH = str2double(get(handles.WallHEdit, 'String'));

% Hints: get(hObject,'String') returns contents of WallHEdit as text
%        str2double(get(hObject,'String')) returns contents of WallHEdit as a double
guidata(hObject, handles);


% --- Executes during object creation, after setting all properties.
function WallHEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to WallHEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function RoofAEdit_Callback(hObject, eventdata, handles)
% hObject    handle to RoofAEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

handles.RoofA = str2double(get(handles.RoofAEdit, 'String'));

% Hints: get(hObject,'String') returns contents of RoofAEdit as text
%        str2double(get(hObject,'String')) returns contents of RoofAEdit as a double
guidata(hObject, handles);


% --- Executes during object creation, after setting all properties.
function RoofAEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to RoofAEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end

% --- Executes on button press in garagecheck.
function garagecheck_Callback(hObject, eventdata, handles)
% hObject    handle to garagecheck (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

handles.garagechoice = get(handles.garagecheck, 'Value')

% Hint: get(hObject,'Value') returns toggle state of garagecheck
guidata(hObject, handles);

% --- Executes on slider movement.
function windowtrans_Callback(hObject, eventdata, handles)
% hObject    handle to windowtrans (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

WindowTransMin = get(handles.windowtrans,'Min');
WindowTransMax = get(handles.windowtrans,'Max');
handles.windowtrans = get(handles.windowtrans,'Value');

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider
guidata(hObject, handles);


% --- Executes during object creation, after setting all properties.
function windowtrans_CreateFcn(hObject, eventdata, handles)
% hObject    handle to windowtrans (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background.
if isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor',[.9 .9 .9]);
end


% --- Executes on button press in createhouse.
function createhouse_Callback(hObject, eventdata, handles)
   
if get(handles.gridview,'value') == 1 
    g = 2; 
else 
    g = 15;
end 

%% Begin Outer House Plot (Axes 1) 
m = tand(handles.RoofA);  
axes(handles.axes1);
cla(handles.axes1);

%% Base/Floor

[xB,yB] = ndgrid(linspace(0,handles.BaseL,g), linspace(0,handles.BaseW,g));
zB = (xB*0);
handles.base = surf(xB,yB,zB,'FaceColor','k');
hold on

%% Walls

%Front Wall (w/Door opening)
[xFW,zFW] = ndgrid(0:.5:handles.BaseL, 0:.5:handles.WallH);
yFW = (xFW*0);
yFW(xFW>.4*handles.BaseL & xFW<.6*handles.BaseL & zFW<.8*handles.WallH) = nan;
handles.fwall = surf(xFW,yFW,zFW,'FaceColor',[.6471 .1647 .1647]);
hold on

%Back Wall
[xBW,zBW] = ndgrid(0:.5:handles.BaseL, 0:.5:handles.WallH);
yBW = (xBW*0)+handles.BaseW;
yBW(xBW>.2*handles.BaseL & xBW<.4*handles.BaseL & zBW<.6*handles.WallH) = nan;
handles.bwall = surf(xBW,yBW,zBW, 'FaceColor', [.6471 .1647 .1647]);

%Right Wall
[yRW,zRW] = ndgrid(0:.5:handles.BaseW, 0:.5:handles.WallH);
xRW = (yRW*0)+handles.BaseL;
xRW(yRW>.25*handles.BaseW & yRW<.75*handles.BaseW & zRW>.5*handles.WallH & zRW<.7*handles.WallH) = nan;
handles.rwall = surf(xRW,yRW,zRW, 'FaceColor', [.6471 .1647 .1647]);

%Left Wall
[yLW,zLW] = ndgrid(0:.5:handles.BaseW, 0:.5:handles.WallH);
xLW = (yLW*0);
xLW(yLW>.25*handles.BaseW & yLW<.75*handles.BaseW & zLW>.5*handles.WallH & zLW<.7*handles.WallH) = nan;
handles.lwall = surf(xLW,yLW,zLW, 'FaceColor', [.6471 .1647 .1647]);

%% Roof

%Left Panel
[xLP,yLP] = ndgrid(0:.5:(handles.BaseL/2), 0:.5:handles.BaseW);
zLP = (m*xLP)+handles.WallH;
handles.lpanel = surf(xLP,yLP,zLP,'FaceColor','g')
hold on

%Right Panel
[xRP,yRP] = ndgrid((handles.BaseL/2):.5:handles.BaseL, 0:.5:handles.BaseW);
zRP = (-m*xRP)+(handles.WallH+m*handles.BaseL);
handles.rpanel = surf(xRP,yRP,zRP,'FaceColor','g')

%% Roof Triangles

%Front Triangle
[xFT,zFT] = ndgrid(0:.25:handles.BaseL, handles.WallH:.25:(m*handles.BaseL/2)+handles.WallH);
yFT = 0*xFT;
yFT(zFT>(m*xFT+handles.WallH)) = nan;
yFT(zFT>(-m*xFT+(m*handles.BaseL+handles.WallH))) = nan;
handles.ftri = surf(xFT,yFT,zFT,'FaceColor','g')

%Back Triangle
[xBT,zBT] = ndgrid(0:.25:handles.BaseL, handles.WallH:.25:(m*handles.BaseL/2)+handles.WallH);
yBT = (xBT*0)+handles.BaseW;
yBT(zBT>(m*xBT+handles.WallH)) = nan;
yBT(zBT>(-m*xBT+(m*handles.BaseL+handles.WallH))) = nan;
handles.btri = surf(xBT,yBT,zBT,'FaceColor','g')

%% Doors

%Door (Front Door)
[xD,zD] = ndgrid(.4*handles.BaseL:.5:.6*handles.BaseL, 0:.5:.8*handles.WallH);
yD = xD*0;
handles.door = surf(xD,yD,zD,'FaceColor','b');

%Back Door
[xBD,zBD] = ndgrid(.2*handles.BaseL:.5:.4*handles.BaseL, 0:.5:.6*handles.WallH);
yBD = (xBD*0)+handles.BaseW;
handles.backdoor = surf(xBD,yBD,zBD,'FaceColor','b');

%% Windows

%Left Window
[yLWin,zLWin] = ndgrid(.25*handles.BaseW:.5:.75*handles.BaseW, .5*handles.WallH:.5:.75*handles.WallH);
xLWin = (yLWin*0);
handles.lwin = surf(xLWin,yLWin,zLWin,'FaceAlpha',get(handles.windowtrans,'value'),'FaceColor','w');

%Right Window
[yRWin,zRWin] = ndgrid(.25*handles.BaseW:.5:.75*handles.BaseW, .5*handles.WallH:.5:.75*handles.WallH);
xRWin = (yRWin*0)+handles.BaseL;
handles.rwin = surf(xRWin,yRWin,zRWin,'FaceAlpha',get(handles.windowtrans,'value'),'FaceColor','w')


%% Desk and chair
 
%Desktop
[xDT,yDT] = ndgrid(.5*handles.BaseL:.5:.65*handles.BaseL, .5*handles.BaseW:.5:.65*handles.BaseW);
[xDN,zDN] = ndgrid(.5*handles.BaseL:.5:.65*handles.BaseL, 0:.5:.15*handles.WallH);
zDT = max(zDN(:)) * ones(size(xDT));
handles.desk = surf(xDT,yDT,zDT,'FaceColor','r')
 
%DeskNearLeg
yDN = min(yDT(:)) * ones(size(xDN));
handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor','r')

 %DeskFar
yDF= max(yDT(:)) * ones(size(xDN));
handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor','r')

%% Garage

if get(handles.garagecheck,'value') == 1
    %% Garage Base/Floor

    [xBG,yBG] = ndgrid(-handles.BaseL:1:0, 0:1:handles.BaseW/2);
    zBG = (xBG*0);
    surf(xBG,yBG,zBG,'FaceColor','k')
    hold on
    
    
    [xBG,yBG] = ndgrid(-handles.BaseL:1:0, 0:1:handles.BaseW/2);
    zBG = (xBG*0)+handles.WallH/2;
    surf(xBG,yBG,zBG,'FaceColor','g')
    hold on
    
    %% Garage Walls

    %Front Wall (w/Door opening)
    [xFWG,zFWG] = ndgrid(-handles.BaseL:.5:0, 0:.5:handles.WallH/2);
    yFWG = (xFWG*0);
    yFWG(xFWG>-.75*handles.BaseL & xFWG<-.25*handles.BaseL & zFWG<.25*handles.WallH) = nan;
    surf(xFWG,yFWG,zFWG);
    hold on
    
    %Back Wall
    [xBWG,zBWG] = ndgrid(-handles.BaseL:.5:0, 0:.5:handles.WallH/2);
    yBWG = (xBWG*0)+handles.BaseW/2;
    surf(xBWG,yBWG,zBWG);
    hold on 

    %Left Wall
    [yRWG,zRWG] = ndgrid(0:.5:handles.BaseW/2, 0:.5:handles.WallH/2);
    xRWG = (yRWG*0)-handles.BaseL;
    surf(xRWG,yRWG,zRWG);
    hold on

    %Garage Opening
    [xGD,zGD] = ndgrid(-.75*handles.BaseL:.5:-.25*handles.BaseL, 0:.5:.25*handles.WallH);
    yGD = xGD*0;
    handles.gdoor = surf(xGD,yGD,zGD,'FaceColor','b'); 
    hold on
    
end

%% Begin Inner House Plot -- Front Wall Discarded (Axes 2) 
    % Begin inner view of house from Front of House 

% hObject    handle to createhouse (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

axes(handles.axes2);
cla(handles.axes2);
grid on

% --- Plot the Basic House Structure - View from Front Wall ---

% --- Outer Walls 
% Floor 
handles.base = surf(xB,yB,zB,'FaceColor','k');
hold on

% Back Wall 
handles.bwall = surf(xBW,yBW,zBW,'FaceColor',[.6471 .1647 .1647])
hold on 

% Right Wall 
handles.rwall = surf(xRW,yRW,zRW,'FaceColor',[.6471 .1647 .1647]);
hold on 

% Left Wall 
handles.lwall = surf(xLW,yLW,zLW, 'FaceColor',[.6471 .1647 .1647]);
hold on

% Back Door 
handles.backdoor = surf(xBD,yBD,zBD,'FaceColor','b');
hold on

% --- Roof Panels  
% Roof Left Panel
handles.lpanel = surf(xLP,yLP,zLP,'FaceColor',[.6471 .1647 .1647])
hold on

% Roof Right Panel  
handles.rpanel = surf(xRP,yRP,zRP,'FaceColor',[.6471 .1647 .1647])
hold on

% Roof Back Panel 
handles.btri = surf(xBT,yBT,zBT,'FaceColor','g')
hold on

% Desktop
handles.desk = surf(xDT,yDT,zDT,'FaceColor','r')
hold on
 
% DeskNearLeg
handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor','r')
hold on

 % DeskFar  
handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor','r')
hold on

guidata(hObject, handles);

%% Begin Inner House Plot -- Roof Discarded (Axes 3) 
axes(handles.axes3); 
cla(handles.axes3);
colormap white

% --- Plot the Basic House Structure - View from Front Wall ---

% --- Outer Walls 
% Floor 
handles.base = surf(xB,yB,zB,'FaceColor','k');
hold on

% Front Wall 
handles.fwall = surf(xFW,yFW,zFW,'FaceColor',[.6471 .1647 .1647]);
hold on

% Back Wall 
handles.bwall = surf(xBW,yBW,zBW,'FaceColor',[.6471 .1647 .1647])
hold on 

% Right Wall 
handles.rwall = surf(xRW,yRW,zRW,'FaceColor',[.6471 .1647 .1647]);
hold on 

% Left Wall 
handles.lwall = surf(xLW,yLW,zLW, 'FaceColor',[.6471 .1647 .1647]);
hold on

% Front Door 
handles.door = surf(xD,yD,zD,'FaceColor','b');
hold on

% Back Door 
handles.backdoor = surf(xBD,yBD,zBD,'FaceColor','b');
hold on

% Desktop
handles.desk = surf(xDT,yDT,zDT,'FaceColor','r')
hold on
 
% DeskNearLeg
handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor','r')
hold on

% DeskFar
handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor','r')
hold on
guidata(hObject, handles);

%% Begin Inner House Plot -- Roof Discarded (Axes 4)
axes(handles.axes4); 
cla(handles.axes4); 
colormap white 
grid on

% --- Plot the Basic House Structure - View from Front Wall ---

% --- Outer Walls 
% Floor 
handles.base = surf(xB,yB,zB,'FaceColor','k');
hold on

% Front Wall 
handles.fwall = surf(xFW,yFW,zFW,'FaceColor',[.6471 .1647 .1647]);
hold on

% Right Wall 
handles.rwall = surf(xRW,yRW,zRW,'FaceColor',[.6471 .1647 .1647]);
hold on 

% Left Wall 
handles.lwall = surf(xLW,yLW,zLW, 'FaceColor',[.6471 .1647 .1647]);
hold on

% Front Door 
handles.door = surf(xD,yD,zD,'FaceColor','b');
hold on

% --- Roof Panels  
% Roof Left Panel
handles.lpanel = surf(xLP,yLP,zLP,'FaceColor',[.6471 .1647 .1647])
hold on

% Roof Right Panel  
handles.rpanel = surf(xRP,yRP,zRP,'FaceColor',[.6471 .1647 .1647])
hold on

% Roof Front Panel
handles.ftri = surf(xFT,yFT,zFT,'FaceColor','g')
hold on

% Desktop
handles.desk = surf(xDT,yDT,zDT,'FaceColor','r')
hold on
 
% DeskNearLeg
handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor','r')
hold on

 % DeskFar
handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor','r')
hold on
guidata(hObject, handles);

% --- Executes on selection change in listbox1.
function listbox1_Callback(hObject, eventdata, handles)
% hObject    handle to listbox1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns listbox1 contents as cell array
%        contents{get(hObject,'Value')} returns selected item from listbox1



% --- Executes during object creation, after setting all properties.
function listbox1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to listbox1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: listbox controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end

% --- Executes on button press in opendoor.
function opendoor_Callback(hObject, eventdata, handles)

if get(handles.opendoor,'value') == 0
     [xD,zD] = ndgrid(.4*handles.BaseL:.5:.6*handles.BaseL, 0:.5:.8*handles.WallH);
    yD = xD*0;
    handles.door = surf(xD,yD,zD,'FaceColor','b');
    set(handles.opendoor,'string','Open Door')
    % Update handles structure
    guidata(hObject, handles);
else
    delete(handles.door)
    set(handles.opendoor,'string','Close Door')
end


% hObject    handle to opendoor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of opendoor

% --- Executes on button press in openbackdoor.
function openbackdoor_Callback(hObject, eventdata, handles)

if get(handles.openbackdoor,'value') == 0
    [xBD,zBD] = ndgrid(.2*handles.BaseL:.5:.4*handles.BaseL, 0:.5:.6*handles.WallH);
    yBD = (xBD*0)+handles.BaseW;
    handles.backdoor = surf(xBD,yBD,zBD,'FaceColor','b');
    set(handles.openbackdoor,'string','Open Back Door')
    % Update handles structure
    guidata(hObject, handles);
else
    delete(handles.backdoor)
    set(handles.openbackdoor,'string','Close Back Door')
end

% hObject    handle to openbackdoor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of openbackdoor


% --- Executes on button press in opengaragedoor.
function opengaragedoor_Callback(hObject, eventdata, handles)
if get(handles.opengaragedoor,'value') == 0
    [xGD,zGD] = ndgrid(-.75*handles.BaseL:.5:-.25*handles.BaseL, 0:.5:.25*handles.WallH);
    yGD = xGD*0;
    handles.gdoor = surf(xGD,yGD,zGD,'FaceColor','b');
    set(handles.opengaragedoor,'string','Open Garage Door')
    % Update handles structure
    guidata(hObject, handles);
else
    delete(handles.gdoor)
    set(handles.opengaragedoor,'string','Close Garage Door')
end

% hObject    handle to opengaragedoor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of opengaragedoor


% --- Executes on button press in addFurniture.
function addFurniture_Callback(hObject, eventdata, handles)
% hObject    handle to addFurniture (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

if get(handles.gridview,'value') == 1 
    g = 2; 
else 
    g = 5;
end 

if get(handles.listbox1,'value') == 1
    
    c = uisetcolor([1 0 0]) 
   
    dcm_obj = datacursormode(HouseGUI)
    set(dcm_obj, 'Enable', 'on')
    w = waitforbuttonpress;
    
    if w == 0 
        pos = getCursorInfo(dcm_obj);
        pos = pos.Position;
        xpos = pos(1); 
        ypos = pos(2);  
        set(dcm_obj,'DisplayStyle', 'Window','SnapToDataVertex', 'off', 'Enable', 'off')
    end
    
    xFactor = xpos/handles.BaseL; 
    xMin = xFactor - 0.035; 
    xMax = xFactor + 0.035; 
    yFactor = ypos/handles.BaseW; 
    yMin = yFactor - 0.035; 
    yMax = yFactor + 0.035; 
    
    %Desktop
    [xDT yDT] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(yMin*handles.BaseW,yMax*handles.BaseW,g))
    [xDN,zDN] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(0,.09*handles.WallH,g));
    zDT = max(zDN(:)) * ones(size(xDT));
    
    %DeskNearLeg
    yDN = min(yDT(:)) * ones(size(xDN));
    
    %DeskFar
    yDF= max(yDT(:)) * ones(size(xDN));
    
    %Plot in All Axes
    axes(handles.axes1);
    handles.desk = surf(xDT,yDT,zDT,'FaceColor',c)
    handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor',c)
    handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor',c)
    
    axes(handles.axes2);
    handles.desk = surf(xDT,yDT,zDT,'FaceColor',c)
    handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor',c)
    handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor',c)
    
    axes(handles.axes3);
    handles.desk = surf(xDT,yDT,zDT,'FaceColor',c)
    handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor',c)
    handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor',c)
    
    axes(handles.axes4);
    handles.desk = surf(xDT,yDT,zDT,'FaceColor',c)
    handles.desknearleg = surf(xDN,yDN,zDN,'FaceColor',c)
    handles.desknearfar = surf(xDN,yDF,zDN,'FaceColor',c)
    
elseif get(handles.listbox1,'value') == 2
    
    c = uisetcolor([1 0 0]) 
    
    dcm_obj = datacursormode(HouseGUI)
    set(dcm_obj, 'Enable', 'on')
    w = waitforbuttonpress;
    
    if w == 0 
        pos = getCursorInfo(dcm_obj);
        pos = pos.Position
        set(dcm_obj,'DisplayStyle', 'Window','SnapToDataVertex', 'off', 'Enable', 'off')
    end
    
    xpos = pos(1); 
    ypos = pos(2); 
    
    xFactor = xpos/handles.BaseL; 
    xMin = xFactor - 0.025; 
    xMax = xFactor + 0.025; 
    yFactor = ypos/handles.BaseW; 
    yMin = yFactor - 0.03; 
    yMax = yFactor + 0.03; 
    
    %Chair Seat 
    [xCT yCT] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(yMin*handles.BaseW,yMax*handles.BaseW,g));
    [xCN zCN] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(0,0.75,g)); 
    zCT = max(zCN(:)) * ones(size(xCT));
     
    %Chair Seat Back 
    [yCB zCB] = ndgrid(linspace(yMin*handles.BaseW,yMax*handles.BaseW,g), linspace(.7,2.5,g));
    xCB = max(xCT(:)) * ones(size(yCB));
    
    %Chair Leg Near 
    yCN = min(yCT(:)) * ones(size(xCT));
    
    %Chair Leg Far 
    yCF = max(yCT(:)) * ones(size(xCT));
    
    axes(handles.axes1); 
    handles.ChairTop = surf(xCT, yCT, zCT)
    handles.ChairBack = surf(xCB, yCB, zCB)
    handles.ChairLegNear = surf(xCT, yCN, zCN) 
    handles.ChairLegFar = surf(xCT, yCF, zCN)
    
    axes(handles.axes2); 
    handles.ChairTop = surf(xCT, yCT, zCT)
    handles.ChairBack = surf(xCB, yCB, zCB)
    handles.ChairLegNear = surf(xCT, yCN, zCN) 
    handles.ChairLegFar = surf(xCT, yCF, zCN) 

    axes(handles.axes3); 
    handles.ChairTop = surf(xCT, yCT, zCT)
    handles.ChairBack = surf(xCB, yCB, zCB)
    handles.ChairLegNear = surf(xCT, yCN, zCN) 
    handles.ChairLegFar = surf(xCT, yCF, zCN)
    
    axes(handles.axes4);
    handles.ChairTop = surf(xCT, yCT, zCT)
    handles.ChairBack = surf(xCB, yCB, zCB)
    handles.ChairLegNear = surf(xCT, yCN, zCN) 
    handles.ChairLegFar = surf(xCT, yCF, zCN)
    
elseif get(handles.listbox1,'value') == 3
    
    c = uisetcolor([1 0 0]) 
    
    dcm_obj = datacursormode(HouseGUI)
    set(dcm_obj, 'Enable', 'on')
    w = waitforbuttonpress;
    
    
    if w == 0 
        pos = getCursorInfo(dcm_obj);
        pos = pos.Position
        set(dcm_obj,'DisplayStyle', 'Window','SnapToDataVertex', 'off', 'Enable', 'off')
    end
    
    xpos = pos(1); 
    ypos = pos(2); 
    
    xFactor = xpos/handles.BaseL; 
    xMin = xFactor - 0.075; 
    xMax = xFactor + 0.075; 
    yFactor = ypos/handles.BaseW; 
    yMin = yFactor - 0.075; 
    yMax = yFactor + 0.075; 
    
    %Tabletop
    [xTT yTT] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(yMin*handles.BaseW,yMax*handles.BaseW,g))
    [xTN,zTN] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(0,.15*handles.WallH,g));
    zTT = max(zTN(:)) * ones(size(xTT));
    
    %TableNearLeg
    yTN = min(yTT(:)) * ones(size(xTN));
    
    %TableFar
    yTF= max(yTT(:)) * ones(size(xTN));
    
    axes(handles.axes1);
    handles.table = surf(xTT,yTT,zTT,'FaceColor',c)
    handles.tablenearleg = surf(xTN,yTN,zTN,'FaceColor',c)
    handles.tablenearfar = surf(xTN,yTF,zTN,'FaceColor',c)
    
    axes(handles.axes2);
    handles.table = surf(xTT,yTT,zTT,'FaceColor',c)
    handles.tablenearleg = surf(xTN,yTN,zTN,'FaceColor',c)
    handles.tablenearfar = surf(xTN,yTF,zTN,'FaceColor',c)
    
    axes(handles.axes3);
    handles.table = surf(xTT,yTT,zTT,'FaceColor',c)
    handles.tablenearleg = surf(xTN,yTN,zTN,'FaceColor',c)
    handles.tablenearfar = surf(xTN,yTF,zTN,'FaceColor',c)
    
    axes(handles.axes4);
    handles.table = surf(xTT,yTT,zTT,'FaceColor',c)
    handles.tablenearleg = surf(xTN,yTN,zTN,'FaceColor',c)
    handles.tablenearfar = surf(xTN,yTF,zTN,'FaceColor',c)
    
elseif get(handles.listbox1,'value') == 4
    
    c = uisetcolor([1 0 0]) 
    dcm_obj = datacursormode(HouseGUI)
    set(dcm_obj, 'Enable', 'on')
    w = waitforbuttonpress;
    
    
    if w == 0 
        pos = getCursorInfo(dcm_obj);
        pos = pos.Position
        set(dcm_obj,'DisplayStyle', 'Window','SnapToDataVertex', 'off', 'Enable', 'off')
    end
    
    xpos = pos(1); 
    ypos = pos(2); 
    
    xFactor = xpos/handles.BaseL; 
    xMin = xFactor - 0.0385; 
    xMax = xFactor + 0.0385; 
    yFactor = ypos/handles.BaseW; 
    yMin = yFactor - 0.12; 
    yMax = yFactor + 0.12; 
    
    % Bed Top (AKA Matress) 
    [xBT yBT] = ndgrid(linspace(xMin*handles.BaseL, xMax*handles.BaseL,g), linspace(yMin*handles.BaseW, yMax*handles.BaseW, g))
    [yBN zBN] = ndgrid(linspace(yMin*handles.BaseW, yMax*handles.BaseW,g), linspace(0,1.25,g))
    zBT = max(zBN(:)) * ones(size(yBT))
    
    % Bed Headrest 
    [xBB zBB] = ndgrid(linspace(xMin*handles.BaseL, xMax*handles.BaseL,g), linspace(0,4,g))
    yBB = min(yBT(:)) * ones(size(xBB)); 
    
    % Bed Leg Near 
    xBN = min(xBT(:)) * ones(size(yBN))
    
    % Bed Leg Far 
    xBF = max(xBT(:)) * ones(size(yBN))
    
    axes(handles.axes1);
    handles.BedTop = surf(xBT, yBT, zBT,'FaceColor', c)
    handles.BedHeadrest = surf(xBB, yBB, zBB,'FaceColor',c)
    handles.BedLegNear = surf(xBN, yBN, zBN, 'FaceColor', c) 
    handles.BedLegFar = surf(xBF, yBN, zBN, 'FaceColor', c)
    
    axes(handles.axes2);
    handles.BedTop = surf(xBT, yBT, zBT,'FaceColor', c)
    handles.BedHeadrest = surf(xBB, yBB, zBB,'FaceColor',c)
    handles.BedLegNear = surf(xBN, yBN, zBN, 'FaceColor', c) 
    handles.BedLegFar = surf(xBF, yBN, zBN, 'FaceColor', c)
    
    axes(handles.axes3);
    handles.BedTop = surf(xBT, yBT, zBT,'FaceColor', c)
    handles.BedHeadrest = surf(xBB, yBB, zBB,'FaceColor',c)
    handles.BedLegNear = surf(xBN, yBN, zBN, 'FaceColor', c) 
    handles.BedLegFar = surf(xBF, yBN, zBN, 'FaceColor', c)
    
    axes(handles.axes4);
    handles.BedTop = surf(xBT, yBT, zBT,'FaceColor', c)
    handles.BedHeadrest = surf(xBB, yBB, zBB,'FaceColor',c)
    handles.BedLegNear = surf(xBN, yBN, zBN, 'FaceColor', c) 
    handles.BedLegFar = surf(xBF, yBN, zBN, 'FaceColor', c)
    
elseif get(handles.listbox1,'value') == 5
    
    c = uisetcolor([1 0 0]) 
    
    dcm_obj = datacursormode(HouseGUI)
    set(dcm_obj, 'Enable', 'on')
    w = waitforbuttonpress;
    
    
    if w == 0 
        pos = getCursorInfo(dcm_obj);
        pos = pos.Position
        set(dcm_obj,'DisplayStyle', 'Window','SnapToDataVertex', 'off', 'Enable', 'off')
    end
    
    xpos = pos(1); 
    ypos = pos(2); 
    
    xFactor = xpos/handles.BaseL; 
    xMin = xFactor - 0.03; 
    xMax = xFactor + 0.03; 
    yFactor = ypos/handles.BaseW; 
    yMin = yFactor - 0.075; 
    yMax = yFactor + 0.075; 
    
    %Couch Seat 
    [xCoT yCoT] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(yMin*handles.BaseW,yMax*handles.BaseW,g));
    [xCoN zCoN] = ndgrid(linspace(xMin*handles.BaseL,xMax*handles.BaseL,g), linspace(0,.85,g)); 
    zCoT = max(zCoN(:)) * ones(size(xCoT));
     
    %Couch Seat Back 
    [yCoB zCoB] = ndgrid(linspace(yMin*handles.BaseW,yMax*handles.BaseW,g), linspace(.7,2.5,g));
    xCoB = max(xCoT(:)) * ones(size(yCoB));
    
    %Couch Leg Near 
    yCoN = min(yCoT(:)) * ones(size(xCoT));
     
    %Couch Leg Far 
    yCoF = max(yCoT(:)) * ones(size(xCoT));
    
    axes(handles.axes1); 
    handles.CouchTop = surf(xCoT, yCoT, zCoT,'FaceColor', c)
    handles.CouchBack = surf(xCoB, yCoB, zCoB, 'FaceColor', c)
    handles.CouchLegNear = surf(xCoT, yCoN, zCoN, 'FaceColor', c) 
    handles.CouchLegFar = surf(xCoT, yCoF, zCoN, 'FaceColor', c)
    
    axes(handles.axes2); 
    handles.CouchTop = surf(xCoT, yCoT, zCoT,'FaceColor', c)
    handles.CouchBack = surf(xCoB, yCoB, zCoB, 'FaceColor', c)
    handles.CouchLegNear = surf(xCoT, yCoN, zCoN, 'FaceColor', c) 
    handles.CouchLegFar = surf(xCoT, yCoF, zCoN, 'FaceColor', c)
    
    axes(handles.axes3); 
    handles.CouchTop = surf(xCoT, yCoT, zCoT,'FaceColor', c)
    handles.CouchBack = surf(xCoB, yCoB, zCoB, 'FaceColor', c)
    handles.CouchLegNear = surf(xCoT, yCoN, zCoN, 'FaceColor', c) 
    handles.CouchLegFar = surf(xCoT, yCoF, zCoN, 'FaceColor', c)
    
    axes(handles.axes4); 
    handles.CouchTop = surf(xCoT, yCoT, zCoT,'FaceColor', c)
    handles.CouchBack = surf(xCoB, yCoB, zCoB, 'FaceColor', c)
    handles.CouchLegNear = surf(xCoT, yCoN, zCoN, 'FaceColor', c) 
    handles.CouchLegFar = surf(xCoT, yCoF, zCoN, 'FaceColor', c)
else
    disp('Error')
    get(handles.listbox1,'value') % ERROR: Nothing selected.
end
guidata(hObject,handles);


% --- Executes on button press in gridview.
function gridview_Callback(hObject, eventdata, handles)
% hObject    handle to gridview (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of gridview
